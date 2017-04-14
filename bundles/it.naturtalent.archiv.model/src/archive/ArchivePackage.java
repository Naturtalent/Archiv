/**
 */
package archive;

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
 * @see archive.ArchiveFactory
 * @model kind="package"
 * @generated
 */
public interface ArchivePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "archive";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/archive";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "archive";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchivePackage eINSTANCE = archive.impl.ArchivePackageImpl.init();

	/**
	 * The meta object id for the '{@link archive.impl.RegisterImpl <em>Register</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see archive.impl.RegisterImpl
	 * @see archive.impl.ArchivePackageImpl#getRegister()
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
	 * The meta object id for the '{@link archive.impl.OrdnerImpl <em>Ordner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see archive.impl.OrdnerImpl
	 * @see archive.impl.ArchivePackageImpl#getOrdner()
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
	 * The feature id for the '<em><b>Archiv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDNER__ARCHIV = 3;

	/**
	 * The number of structural features of the '<em>Ordner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDNER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Ordner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDNER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link archive.impl.ArchivImpl <em>Archiv</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see archive.impl.ArchivImpl
	 * @see archive.impl.ArchivePackageImpl#getArchiv()
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
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIV__LOCATION = 1;

	/**
	 * The number of structural features of the '<em>Archiv</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIV_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Archiv</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIV_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link archive.RegisterType <em>Register Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see archive.RegisterType
	 * @see archive.impl.ArchivePackageImpl#getRegisterType()
	 * @generated
	 */
	int REGISTER_TYPE = 3;


	/**
	 * The meta object id for the '<em>Empty String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see archive.impl.ArchivePackageImpl#getEmptyString()
	 * @generated
	 */
	int EMPTY_STRING = 4;


	/**
	 * Returns the meta object for class '{@link archive.Register <em>Register</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Register</em>'.
	 * @see archive.Register
	 * @generated
	 */
	EClass getRegister();

	/**
	 * Returns the meta object for the attribute '{@link archive.Register#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see archive.Register#getLabel()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_Label();

	/**
	 * Returns the meta object for the attribute '{@link archive.Register#getProjectID <em>Project ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project ID</em>'.
	 * @see archive.Register#getProjectID()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_ProjectID();

	/**
	 * Returns the meta object for the attribute '{@link archive.Register#getCounter <em>Counter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Counter</em>'.
	 * @see archive.Register#getCounter()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_Counter();

	/**
	 * Returns the meta object for the attribute '{@link archive.Register#getNumericData <em>Numeric Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numeric Data</em>'.
	 * @see archive.Register#getNumericData()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_NumericData();

	/**
	 * Returns the meta object for the attribute '{@link archive.Register#getAlphaData <em>Alpha Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha Data</em>'.
	 * @see archive.Register#getAlphaData()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_AlphaData();

	/**
	 * Returns the meta object for the '{@link archive.Register#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Name</em>' operation.
	 * @see archive.Register#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRegister__HasName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link archive.Ordner <em>Ordner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordner</em>'.
	 * @see archive.Ordner
	 * @generated
	 */
	EClass getOrdner();

	/**
	 * Returns the meta object for the attribute '{@link archive.Ordner#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see archive.Ordner#getLabel()
	 * @see #getOrdner()
	 * @generated
	 */
	EAttribute getOrdner_Label();

	/**
	 * Returns the meta object for the containment reference list '{@link archive.Ordner#getRegisters <em>Registers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registers</em>'.
	 * @see archive.Ordner#getRegisters()
	 * @see #getOrdner()
	 * @generated
	 */
	EReference getOrdner_Registers();

	/**
	 * Returns the meta object for the attribute '{@link archive.Ordner#getRegisterType <em>Register Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Register Type</em>'.
	 * @see archive.Ordner#getRegisterType()
	 * @see #getOrdner()
	 * @generated
	 */
	EAttribute getOrdner_RegisterType();

	/**
	 * Returns the meta object for the reference '{@link archive.Ordner#getArchiv <em>Archiv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Archiv</em>'.
	 * @see archive.Ordner#getArchiv()
	 * @see #getOrdner()
	 * @generated
	 */
	EReference getOrdner_Archiv();

	/**
	 * Returns the meta object for class '{@link archive.Archiv <em>Archiv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Archiv</em>'.
	 * @see archive.Archiv
	 * @generated
	 */
	EClass getArchiv();

	/**
	 * Returns the meta object for the attribute '{@link archive.Archiv#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see archive.Archiv#getName()
	 * @see #getArchiv()
	 * @generated
	 */
	EAttribute getArchiv_Name();

	/**
	 * Returns the meta object for the reference '{@link archive.Archiv#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Location</em>'.
	 * @see archive.Archiv#getLocation()
	 * @see #getArchiv()
	 * @generated
	 */
	EReference getArchiv_Location();

	/**
	 * Returns the meta object for enum '{@link archive.RegisterType <em>Register Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Register Type</em>'.
	 * @see archive.RegisterType
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
	ArchiveFactory getArchiveFactory();

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
		 * The meta object literal for the '{@link archive.impl.RegisterImpl <em>Register</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see archive.impl.RegisterImpl
		 * @see archive.impl.ArchivePackageImpl#getRegister()
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
		 * The meta object literal for the '{@link archive.impl.OrdnerImpl <em>Ordner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see archive.impl.OrdnerImpl
		 * @see archive.impl.ArchivePackageImpl#getOrdner()
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
		 * The meta object literal for the '<em><b>Archiv</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDNER__ARCHIV = eINSTANCE.getOrdner_Archiv();

		/**
		 * The meta object literal for the '{@link archive.impl.ArchivImpl <em>Archiv</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see archive.impl.ArchivImpl
		 * @see archive.impl.ArchivePackageImpl#getArchiv()
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
		 * The meta object literal for the '<em><b>Location</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHIV__LOCATION = eINSTANCE.getArchiv_Location();

		/**
		 * The meta object literal for the '{@link archive.RegisterType <em>Register Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see archive.RegisterType
		 * @see archive.impl.ArchivePackageImpl#getRegisterType()
		 * @generated
		 */
		EEnum REGISTER_TYPE = eINSTANCE.getRegisterType();

		/**
		 * The meta object literal for the '<em>Empty String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see archive.impl.ArchivePackageImpl#getEmptyString()
		 * @generated
		 */
		EDataType EMPTY_STRING = eINSTANCE.getEmptyString();

	}

} //ArchivePackage
