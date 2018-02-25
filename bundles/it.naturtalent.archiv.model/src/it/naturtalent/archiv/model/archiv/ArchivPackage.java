/**
 */
package it.naturtalent.archiv.model.archiv;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see it.naturtalent.archiv.model.archiv.ArchivFactory
 * @model kind="package"
 * @generated
 */
public interface ArchivPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "archiv";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://it.naturtalent/archiv";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "archiv";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchivPackage eINSTANCE = it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl.init();

	/**
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archiv.impl.RegisterImpl <em>Register</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archiv.impl.RegisterImpl
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getRegister()
	 * @generated
	 */
	int REGISTER = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Project ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER__PROJECT_ID = 1;

	/**
	 * The feature id for the '<em><b>Counter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER__COUNTER = 2;

	/**
	 * The feature id for the '<em><b>Numeric Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER__NUMERIC_DATA = 3;

	/**
	 * The feature id for the '<em><b>Alpha Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER__ALPHA_DATA = 4;

	/**
	 * The number of structural features of the '<em>Register</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Has Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER___HAS_NAME__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Register</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archiv.impl.OrdnerImpl <em>Ordner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archiv.impl.OrdnerImpl
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getOrdner()
	 * @generated
	 */
	int ORDNER = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDNER__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Registers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDNER__REGISTERS = 1;

	/**
	 * The feature id for the '<em><b>Register Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDNER__REGISTER_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Ordner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDNER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Ordner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDNER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archiv.impl.ArchivImpl <em>Archiv</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchivImpl
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getArchiv()
	 * @generated
	 */
	int ARCHIV = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIV__NAME = 0;

	/**
	 * The feature id for the '<em><b>Ordner</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIV__ORDNER = 1;

	/**
	 * The feature id for the '<em><b>Adresse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIV__ADRESSE = 2;

	/**
	 * The number of structural features of the '<em>Archiv</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIV_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Archiv</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIV_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archiv.impl.ArchiveImpl <em>Archive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchiveImpl
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getArchive()
	 * @generated
	 */
	int ARCHIVE = 3;

	/**
	 * The feature id for the '<em><b>Archiv</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIVE__ARCHIV = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIVE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Archive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIVE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Archive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIVE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archiv.impl.AdresseImpl <em>Adresse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archiv.impl.AdresseImpl
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getAdresse()
	 * @generated
	 */
	int ADRESSE = 4;

	/**
	 * The feature id for the '<em><b>Strasse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSE__STRASSE = 0;

	/**
	 * The feature id for the '<em><b>Nummer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSE__NUMMER = 1;

	/**
	 * The feature id for the '<em><b>Plz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSE__PLZ = 2;

	/**
	 * The feature id for the '<em><b>Ort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSE__ORT = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSE__DESCRIPTION = 4;

	/**
	 * The number of structural features of the '<em>Adresse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Adresse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archiv.impl.AdressenImpl <em>Adressen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archiv.impl.AdressenImpl
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getAdressen()
	 * @generated
	 */
	int ADRESSEN = 5;

	/**
	 * The feature id for the '<em><b>Adresse</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSEN__ADRESSE = 0;

	/**
	 * The number of structural features of the '<em>Adressen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSEN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Adressen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADRESSEN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archiv.RegisterType <em>Register Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archiv.RegisterType
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getRegisterType()
	 * @generated
	 */
	int REGISTER_TYPE = 6;

	/**
	 * The meta object id for the '<em>Empty String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getEmptyString()
	 * @generated
	 */
	int EMPTY_STRING = 7;


	/**
	 * Returns the meta object for class '{@link it.naturtalent.archiv.model.archiv.Register <em>Register</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Register</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Register
	 * @generated
	 */
	EClass getRegister();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Register#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Register#getLabel()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_Label();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Register#getProjectID <em>Project ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project ID</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Register#getProjectID()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_ProjectID();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Register#getCounter <em>Counter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Counter</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Register#getCounter()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_Counter();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Register#getNumericData <em>Numeric Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numeric Data</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Register#getNumericData()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_NumericData();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Register#getAlphaData <em>Alpha Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha Data</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Register#getAlphaData()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_AlphaData();

	/**
	 * Returns the meta object for the '{@link it.naturtalent.archiv.model.archiv.Register#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Name</em>' operation.
	 * @see it.naturtalent.archiv.model.archiv.Register#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRegister__HasName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link it.naturtalent.archiv.model.archiv.Ordner <em>Ordner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordner</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Ordner
	 * @generated
	 */
	EClass getOrdner();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Ordner#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Ordner#getLabel()
	 * @see #getOrdner()
	 * @generated
	 */
	EAttribute getOrdner_Label();

	/**
	 * Returns the meta object for the containment reference list '{@link it.naturtalent.archiv.model.archiv.Ordner#getRegisters <em>Registers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registers</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Ordner#getRegisters()
	 * @see #getOrdner()
	 * @generated
	 */
	EReference getOrdner_Registers();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Ordner#getRegisterType <em>Register Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Register Type</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Ordner#getRegisterType()
	 * @see #getOrdner()
	 * @generated
	 */
	EAttribute getOrdner_RegisterType();

	/**
	 * Returns the meta object for class '{@link it.naturtalent.archiv.model.archiv.Archiv <em>Archiv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Archiv</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Archiv
	 * @generated
	 */
	EClass getArchiv();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Archiv#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Archiv#getName()
	 * @see #getArchiv()
	 * @generated
	 */
	EAttribute getArchiv_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link it.naturtalent.archiv.model.archiv.Archiv#getOrdner <em>Ordner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ordner</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Archiv#getOrdner()
	 * @see #getArchiv()
	 * @generated
	 */
	EReference getArchiv_Ordner();

	/**
	 * Returns the meta object for the reference '{@link it.naturtalent.archiv.model.archiv.Archiv#getAdresse <em>Adresse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Adresse</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Archiv#getAdresse()
	 * @see #getArchiv()
	 * @generated
	 */
	EReference getArchiv_Adresse();

	/**
	 * Returns the meta object for class '{@link it.naturtalent.archiv.model.archiv.Archive <em>Archive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Archive</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Archive
	 * @generated
	 */
	EClass getArchive();

	/**
	 * Returns the meta object for the containment reference list '{@link it.naturtalent.archiv.model.archiv.Archive#getArchiv <em>Archiv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Archiv</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Archive#getArchiv()
	 * @see #getArchive()
	 * @generated
	 */
	EReference getArchive_Archiv();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Archive#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Archive#getName()
	 * @see #getArchive()
	 * @generated
	 */
	EAttribute getArchive_Name();

	/**
	 * Returns the meta object for class '{@link it.naturtalent.archiv.model.archiv.Adresse <em>Adresse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adresse</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Adresse
	 * @generated
	 */
	EClass getAdresse();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Adresse#getStrasse <em>Strasse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strasse</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Adresse#getStrasse()
	 * @see #getAdresse()
	 * @generated
	 */
	EAttribute getAdresse_Strasse();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Adresse#getNummer <em>Nummer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nummer</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Adresse#getNummer()
	 * @see #getAdresse()
	 * @generated
	 */
	EAttribute getAdresse_Nummer();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Adresse#getPlz <em>Plz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plz</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Adresse#getPlz()
	 * @see #getAdresse()
	 * @generated
	 */
	EAttribute getAdresse_Plz();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Adresse#getOrt <em>Ort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ort</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Adresse#getOrt()
	 * @see #getAdresse()
	 * @generated
	 */
	EAttribute getAdresse_Ort();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archiv.Adresse#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Adresse#getDescription()
	 * @see #getAdresse()
	 * @generated
	 */
	EAttribute getAdresse_Description();

	/**
	 * Returns the meta object for class '{@link it.naturtalent.archiv.model.archiv.Adressen <em>Adressen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adressen</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Adressen
	 * @generated
	 */
	EClass getAdressen();

	/**
	 * Returns the meta object for the containment reference list '{@link it.naturtalent.archiv.model.archiv.Adressen#getAdresse <em>Adresse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Adresse</em>'.
	 * @see it.naturtalent.archiv.model.archiv.Adressen#getAdresse()
	 * @see #getAdressen()
	 * @generated
	 */
	EReference getAdressen_Adresse();

	/**
	 * Returns the meta object for enum '{@link it.naturtalent.archiv.model.archiv.RegisterType <em>Register Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Register Type</em>'.
	 * @see it.naturtalent.archiv.model.archiv.RegisterType
	 * @generated
	 */
	EEnum getRegisterType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Empty String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Empty String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="maxLength='20'"
	 * @generated
	 */
	EDataType getEmptyString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchivFactory getArchivFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archiv.impl.RegisterImpl <em>Register</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archiv.impl.RegisterImpl
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getRegister()
		 * @generated
		 */
		EClass REGISTER = eINSTANCE.getRegister();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER__LABEL = eINSTANCE.getRegister_Label();

		/**
		 * The meta object literal for the '<em><b>Project ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER__PROJECT_ID = eINSTANCE.getRegister_ProjectID();

		/**
		 * The meta object literal for the '<em><b>Counter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER__COUNTER = eINSTANCE.getRegister_Counter();

		/**
		 * The meta object literal for the '<em><b>Numeric Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER__NUMERIC_DATA = eINSTANCE.getRegister_NumericData();

		/**
		 * The meta object literal for the '<em><b>Alpha Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER__ALPHA_DATA = eINSTANCE.getRegister_AlphaData();

		/**
		 * The meta object literal for the '<em><b>Has Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REGISTER___HAS_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRegister__HasName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archiv.impl.OrdnerImpl <em>Ordner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archiv.impl.OrdnerImpl
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getOrdner()
		 * @generated
		 */
		EClass ORDNER = eINSTANCE.getOrdner();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDNER__LABEL = eINSTANCE.getOrdner_Label();

		/**
		 * The meta object literal for the '<em><b>Registers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDNER__REGISTERS = eINSTANCE.getOrdner_Registers();

		/**
		 * The meta object literal for the '<em><b>Register Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDNER__REGISTER_TYPE = eINSTANCE.getOrdner_RegisterType();

		/**
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archiv.impl.ArchivImpl <em>Archiv</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchivImpl
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getArchiv()
		 * @generated
		 */
		EClass ARCHIV = eINSTANCE.getArchiv();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHIV__NAME = eINSTANCE.getArchiv_Name();

		/**
		 * The meta object literal for the '<em><b>Ordner</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHIV__ORDNER = eINSTANCE.getArchiv_Ordner();

		/**
		 * The meta object literal for the '<em><b>Adresse</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHIV__ADRESSE = eINSTANCE.getArchiv_Adresse();

		/**
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archiv.impl.ArchiveImpl <em>Archive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchiveImpl
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getArchive()
		 * @generated
		 */
		EClass ARCHIVE = eINSTANCE.getArchive();

		/**
		 * The meta object literal for the '<em><b>Archiv</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHIVE__ARCHIV = eINSTANCE.getArchive_Archiv();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHIVE__NAME = eINSTANCE.getArchive_Name();

		/**
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archiv.impl.AdresseImpl <em>Adresse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archiv.impl.AdresseImpl
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getAdresse()
		 * @generated
		 */
		EClass ADRESSE = eINSTANCE.getAdresse();

		/**
		 * The meta object literal for the '<em><b>Strasse</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADRESSE__STRASSE = eINSTANCE.getAdresse_Strasse();

		/**
		 * The meta object literal for the '<em><b>Nummer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADRESSE__NUMMER = eINSTANCE.getAdresse_Nummer();

		/**
		 * The meta object literal for the '<em><b>Plz</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADRESSE__PLZ = eINSTANCE.getAdresse_Plz();

		/**
		 * The meta object literal for the '<em><b>Ort</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADRESSE__ORT = eINSTANCE.getAdresse_Ort();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADRESSE__DESCRIPTION = eINSTANCE.getAdresse_Description();

		/**
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archiv.impl.AdressenImpl <em>Adressen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archiv.impl.AdressenImpl
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getAdressen()
		 * @generated
		 */
		EClass ADRESSEN = eINSTANCE.getAdressen();

		/**
		 * The meta object literal for the '<em><b>Adresse</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADRESSEN__ADRESSE = eINSTANCE.getAdressen_Adresse();

		/**
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archiv.RegisterType <em>Register Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archiv.RegisterType
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getRegisterType()
		 * @generated
		 */
		EEnum REGISTER_TYPE = eINSTANCE.getRegisterType();

		/**
		 * The meta object literal for the '<em>Empty String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl#getEmptyString()
		 * @generated
		 */
		EDataType EMPTY_STRING = eINSTANCE.getEmptyString();

	}

} //ArchivPackage
