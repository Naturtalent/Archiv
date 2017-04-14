/**
 */
package archive.impl;

import archive.ArchivePackage;
import archive.Register;

import archive.util.ArchiveValidator;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Register</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link archive.impl.RegisterImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link archive.impl.RegisterImpl#getProjectID <em>Project ID</em>}</li>
 *   <li>{@link archive.impl.RegisterImpl#getCounter <em>Counter</em>}</li>
 *   <li>{@link archive.impl.RegisterImpl#getNumericData <em>Numeric Data</em>}</li>
 *   <li>{@link archive.impl.RegisterImpl#getAlphaData <em>Alpha Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RegisterImpl extends MinimalEObjectImpl.Container implements Register
{
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectID() <em>Project ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectID()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectID() <em>Project ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectID()
	 * @generated
	 * @ordered
	 */
	protected String projectID = PROJECT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCounter() <em>Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounter()
	 * @generated
	 * @ordered
	 */
	protected static final short COUNTER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCounter() <em>Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounter()
	 * @generated
	 * @ordered
	 */
	protected short counter = COUNTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumericData() <em>Numeric Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericData()
	 * @generated
	 * @ordered
	 */
	protected static final short NUMERIC_DATA_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumericData() <em>Numeric Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericData()
	 * @generated
	 * @ordered
	 */
	protected short numericData = NUMERIC_DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlphaData() <em>Alpha Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlphaData()
	 * @generated
	 * @ordered
	 */
	protected static final String ALPHA_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlphaData() <em>Alpha Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlphaData()
	 * @generated
	 * @ordered
	 */
	protected String alphaData = ALPHA_DATA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegisterImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ArchivePackage.Literals.REGISTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel)
	{
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivePackage.REGISTER__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectID()
	{
		return projectID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectID(String newProjectID)
	{
		String oldProjectID = projectID;
		projectID = newProjectID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivePackage.REGISTER__PROJECT_ID, oldProjectID, projectID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getCounter()
	{
		return counter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCounter(short newCounter)
	{
		short oldCounter = counter;
		counter = newCounter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivePackage.REGISTER__COUNTER, oldCounter, counter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getNumericData()
	{
		return numericData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumericData(short newNumericData)
	{
		short oldNumericData = numericData;
		numericData = newNumericData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivePackage.REGISTER__NUMERIC_DATA, oldNumericData, numericData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlphaData()
	{
		return alphaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlphaData(String newAlphaData)
	{
		String oldAlphaData = alphaData;
		alphaData = newAlphaData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivePackage.REGISTER__ALPHA_DATA, oldAlphaData, alphaData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasName(DiagnosticChain chain, Map<?, ?> context)
	{
		if (getLabel()==null||getLabel().equals("")) {
			if (chain != null) {
				chain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ArchiveValidator.DIAGNOSTIC_SOURCE,
						 ArchiveValidator.REGISTER__HAS_NAME,
						 "Register brauchen eine Bezeichnung",
						 new Object [] { this, ArchivePackage.eINSTANCE.getRegister_Label() }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ArchivePackage.REGISTER__LABEL:
				return getLabel();
			case ArchivePackage.REGISTER__PROJECT_ID:
				return getProjectID();
			case ArchivePackage.REGISTER__COUNTER:
				return getCounter();
			case ArchivePackage.REGISTER__NUMERIC_DATA:
				return getNumericData();
			case ArchivePackage.REGISTER__ALPHA_DATA:
				return getAlphaData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ArchivePackage.REGISTER__LABEL:
				setLabel((String)newValue);
				return;
			case ArchivePackage.REGISTER__PROJECT_ID:
				setProjectID((String)newValue);
				return;
			case ArchivePackage.REGISTER__COUNTER:
				setCounter((Short)newValue);
				return;
			case ArchivePackage.REGISTER__NUMERIC_DATA:
				setNumericData((Short)newValue);
				return;
			case ArchivePackage.REGISTER__ALPHA_DATA:
				setAlphaData((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ArchivePackage.REGISTER__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case ArchivePackage.REGISTER__PROJECT_ID:
				setProjectID(PROJECT_ID_EDEFAULT);
				return;
			case ArchivePackage.REGISTER__COUNTER:
				setCounter(COUNTER_EDEFAULT);
				return;
			case ArchivePackage.REGISTER__NUMERIC_DATA:
				setNumericData(NUMERIC_DATA_EDEFAULT);
				return;
			case ArchivePackage.REGISTER__ALPHA_DATA:
				setAlphaData(ALPHA_DATA_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ArchivePackage.REGISTER__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case ArchivePackage.REGISTER__PROJECT_ID:
				return PROJECT_ID_EDEFAULT == null ? projectID != null : !PROJECT_ID_EDEFAULT.equals(projectID);
			case ArchivePackage.REGISTER__COUNTER:
				return counter != COUNTER_EDEFAULT;
			case ArchivePackage.REGISTER__NUMERIC_DATA:
				return numericData != NUMERIC_DATA_EDEFAULT;
			case ArchivePackage.REGISTER__ALPHA_DATA:
				return ALPHA_DATA_EDEFAULT == null ? alphaData != null : !ALPHA_DATA_EDEFAULT.equals(alphaData);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case ArchivePackage.REGISTER___HAS_NAME__DIAGNOSTICCHAIN_MAP:
				return hasName((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (label: ");
		result.append(label);
		result.append(", projectID: ");
		result.append(projectID);
		result.append(", counter: ");
		result.append(counter);
		result.append(", numericData: ");
		result.append(numericData);
		result.append(", alphaData: ");
		result.append(alphaData);
		result.append(')');
		return result.toString();
	}

} //RegisterImpl
