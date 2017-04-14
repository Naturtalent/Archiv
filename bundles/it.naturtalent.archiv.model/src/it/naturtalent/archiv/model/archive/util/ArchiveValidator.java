/**
 */
package it.naturtalent.archiv.model.archive.util;

import it.naturtalent.archiv.model.archive.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see it.naturtalent.archiv.model.archive.ArchivePackage
 * @generated
 */
public class ArchiveValidator extends EObjectValidator
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ArchiveValidator INSTANCE = new ArchiveValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "it.naturtalent.archiv.model.archive";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Name' of 'Register'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REGISTER__HAS_NAME = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchiveValidator()
	{
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage()
	{
	  return ArchivePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		switch (classifierID)
		{
			case ArchivePackage.REGISTER:
				return validateRegister((Register)value, diagnostics, context);
			case ArchivePackage.ORDNER:
				return validateOrdner((Ordner)value, diagnostics, context);
			case ArchivePackage.REGISTER_TYPE:
				return validateRegisterType((RegisterType)value, diagnostics, context);
			case ArchivePackage.EMPTY_STRING:
				return validateEmptyString((String)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegister(Register register, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(register, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(register, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(register, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(register, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(register, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(register, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(register, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(register, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(register, diagnostics, context);
		if (result || diagnostics != null) result &= validateRegister_hasName(register, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasName constraint of '<em>Register</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegister_hasName(Register register, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return register.hasName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrdner(Ordner ordner, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(ordner, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegisterType(RegisterType registerType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmptyString(String emptyString, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		boolean result = validateEmptyString_MaxLength(emptyString, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Empty String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmptyString_MaxLength(String emptyString, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		int length = emptyString.length();
		boolean result = length <= 20;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(ArchivePackage.Literals.EMPTY_STRING, emptyString, length, 20, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ArchiveValidator
