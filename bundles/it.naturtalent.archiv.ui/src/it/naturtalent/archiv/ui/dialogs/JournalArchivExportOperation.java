package it.naturtalent.archiv.ui.dialogs;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.style.Font;
import org.odftoolkit.simple.style.StyleTypeDefinitions.FontStyle;
import org.odftoolkit.simple.style.StyleTypeDefinitions.HorizontalAlignmentType;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Column;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.model.archiv.RegisterType;
import it.naturtalent.e4.project.INtProject;
import it.naturtalent.e4.project.expimp.ExpImportData;
import it.naturtalent.e4.project.model.project.NtProject;
import it.naturtalent.e4.project.ui.Activator;

/**
 * Export die Archivdaten erfolgt in einer Runningprogress Operation.
 * 
 * @author dieter
 *
 */
public class JournalArchivExportOperation implements IRunnableWithProgress
{
	//private static final String ARCHIV_TABLENAME = "";
	
	private File destDir; 
	private ExpImportData[] selectedArchives;
	
	
	/*
	 * Im Verzeichnis 'destDir' wird fuer jedes Archiv eine SpreedSheat-Datei angelegt. In den Dateien wiederum 
	 * wird fuer jeden Ordner ein Tabellenblatt angelegt. In jedem Blatt werden Zeile fuer Zeile die Ordnerregister
	 * eingetragen.
	 *    
	 */
	public JournalArchivExportOperation(File destDir, ExpImportData[] archives)
	{
		super();
		this.destDir = destDir;
		this.selectedArchives = archives;
	}

	/**
	 * 
	 */
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
	{
		SpreadsheetDocument calcDoc = null;
		
		monitor.beginTask("Archivdaten exportieren",IProgressMonitor.UNKNOWN);		
		for(ExpImportData exportArchiv : selectedArchives)
		{
			try
			{
				// neues SpreadSheet fuer das adressierte Archiv 
				calcDoc = SpreadsheetDocument.newSpreadsheetDocument();
				List<String>tableNames = getTableNames(calcDoc);
				if(tableNames.size() > 0)
					calcDoc.removeSheet(0);
					
				// alle Ordnerdaten in separaten Tabellen ablegen
				Archiv archiv = (Archiv) exportArchiv.getData();
				for(Ordner ordner : archiv.getOrdner())
				{
					// ein neues Tabellenblatt fuer den momentanen Ordner im SpreadSheet anlegen
					String tableName = ordner.getLabel();
					tableName = StringUtils.isNotEmpty(tableName) ? tableName : "Ordner"; //$NON-NLS-N$ 
					Table projectTable = calcDoc.appendSheet(tableName);
					prepareTable(projectTable);
					
					// die Registerdaten des momentanen Ordners ausgeben 
					int rowIdx = 0;
					EList<Register>registers = ordner.getRegisters();
					for(Register register : registers)					
						addRegisterData(projectTable, ordner.getRegisterType(), register, ++rowIdx);
				}
					
				// SpreadSheet speichern
				saveSpreedSheat(calcDoc, archiv.getName());
				
			} catch (Exception e)
			{
				// im  Fehlerfall wird das momentan in der for-Schleife adressiere 'archiv' ignoriert
				e.printStackTrace();
			}
		}
		monitor.done();
	}
	
	// ein einzelnes Register in einer Zeile der Ordnertabelle speichern
	private void addRegisterData(Table projectTable, RegisterType type, Register register, int rowIdx)
	{
		Cell cell ;
		int cellIndex = 0;
		Row row = projectTable.getRowByIndex(rowIdx);
		
		cell = row.getCellByIndex(cellIndex++);	
		switch (type)
			{
				case NUMERIC_TYPE:
					cell.setStringValue(Short.toString(register.getNumericData()).toString());
					break;
					
				case LETTER_TYPE:
					cell.setStringValue(register.getAlphaData());
					break;

				default:
					break;
			}
				
		cell = row.getCellByIndex(cellIndex++);
		cell.setStringValue(register.getLabel());
		
		cell = row.getCellByIndex(cellIndex++);		
		cell.setStringValue(register.getProjectID());

		NtProject ntProject =  Activator.findNtProject(register.getProjectID());
		if(ntProject != null)
		{
			cell = row.getCellByIndex(cellIndex++);		
			cell.setStringValue(ntProject.getName());			
		}
	}
	
	// eine Ordner-Tabelle vorbereiten (Spaltenkopf und Formatieruenten)
	private void prepareTable(Table projectTable)
	{
		int cellIndex = 0;
		
		// alle Spalten auf optimale Breite schalten
		for(cellIndex = 0;cellIndex < 10;cellIndex++)
		{
			Column column = projectTable.getColumnByIndex(cellIndex);			
			column.setUseOptimalWidth(true);
			column.setWidth(32.0);
		}
		
		// Kopfzeile
		Row row = projectTable.getRowByIndex(0);
		
		cellIndex = 0;
		
		Cell cell = row.getCellByIndex(cellIndex++);	
		cell.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
		cell.setFont(new Font("Arial", FontStyle.BOLD, 10));
		cell.setStringValue("Register");		
				
		cell = row.getCellByIndex(cellIndex++);
		cell.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
		cell.setFont(new Font("Arial", FontStyle.BOLD, 10));
		cell.setStringValue("Inhalt");
		
		cell = row.getCellByIndex(cellIndex++);
		cell.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
		cell.setFont(new Font("Arial", FontStyle.BOLD, 10));
		cell.setStringValue("Projekt ID");
		
		cell = row.getCellByIndex(cellIndex++);
		cell.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
		cell.setFont(new Font("Arial", FontStyle.BOLD, 10));
		cell.setStringValue("Projekt");
	}
	
	// SpreadSheet-Document speichern
	private void saveSpreedSheat(SpreadsheetDocument calcDoc, String archivName) throws Exception
	{
		File sheatFile = new File(destDir, archivName);
		if(sheatFile.exists())
			FileUtils.forceDelete(sheatFile);				
		calcDoc.save(sheatFile);
	}
	
	private List<String> getTableNames(SpreadsheetDocument spreadSheet)
	{
		List<String>tableNames = new ArrayList<String>();
		
		List<Table>tables = spreadSheet.getTableList();
		if((tables != null ) && (!tables.isEmpty()))
		{
			for(Table table : tables)
				tableNames.add(table.getTableName());
		}
						
		return tableNames;
	}

}
