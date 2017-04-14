/**
 */
package it.naturtalent.archiv.model.archive;

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
 * @see it.naturtalent.archiv.model.archive.ArchiveFactory
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
	ArchivePackage eINSTANCE = it.naturtalent.archiv.model.archive.impl.ArchivePackageImpl.init();

	/**
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archive.impl.RegisterImpl <em>Register</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archive.impl.RegisterImpl
	 * @see it.naturtalent.archiv.model.archive.impl.ArchivePackageImpl#getRegister()
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
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archive.impl.OrdnerImpl <em>Ordner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archive.impl.OrdnerImpl
	 * @see it.naturtalent.archiv.model.archive.impl.ArchivePackageImpl#getOrdner()
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
	 * The meta object id for the '{@link it.naturtalent.archiv.model.archive.RegisterType <em>Register Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.naturtalent.archiv.model.archive.RegisterType
	 * @see it.naturtalent.archiv.model.archive.impl.ArchivePackageImpl#getRegisterType()
	 * @generated
	 */
	int REGISTER_TYPE = 2;

	/**
	 * The meta object id for the '<em>Empty String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see it.naturtalent.archiv.model.archive.impl.ArchivePackageImpl#getEmptyString()
	 * @generated
	 */
	int EMPTY_STRING = 3;


	/**
	 * Returns the meta object for class '{@link it.naturtalent.archiv.model.archive.Register <em>Register</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Register</em>'.
	 * @see it.naturtalent.archiv.model.archive.Register
	 * @generated
	 */
	EClass getRegister();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archive.Register#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see it.naturtalent.archiv.model.archive.Register#getLabel()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_Label();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archive.Register#getProjectID <em>Project ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project ID</em>'.
	 * @see it.naturtalent.archiv.model.archive.Register#getProjectID()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_ProjectID();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archive.Register#getCounter <em>Counter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Counter</em>'.
	 * @see it.naturtalent.archiv.model.archive.Register#getCounter()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_Counter();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archive.Register#getNumericData <em>Numeric Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numeric Data</em>'.
	 * @see it.naturtalent.archiv.model.archive.Register#getNumericData()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_NumericData();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archive.Register#getAlphaData <em>Alpha Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha Data</em>'.
	 * @see it.naturtalent.archiv.model.archive.Register#getAlphaData()
	 * @see #getRegister()
	 * @generated
	 */
	EAttribute getRegister_AlphaData();

	/**
	 * Returns the meta object for the '{@link it.naturtalent.archiv.model.archive.Register#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Name</em>' operation.
	 * @see it.naturtalent.archiv.model.archive.Register#hasName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRegister__HasName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link it.naturtalent.archiv.model.archive.Ordner <em>Ordner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordner</em>'.
	 * @see it.naturtalent.archiv.model.archive.Ordner
	 * @generated
	 */
	EClass getOrdner();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archive.Ordner#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see it.naturtalent.archiv.model.archive.Ordner#getLabel()
	 * @see #getOrdner()
	 * @generated
	 */
	EAttribute getOrdner_Label();

	/**
	 * Returns the meta object for the containment reference list '{@link it.naturtalent.archiv.model.archive.Ordner#getRegisters <em>Registers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registers</em>'.
	 * @see it.naturtalent.archiv.model.archive.Ordner#getRegisters()
	 * @see #getOrdner()
	 * @generated
	 */
	EReference getOrdner_Registers();

	/**
	 * Returns the meta object for the attribute '{@link it.naturtalent.archiv.model.archive.Ordner#getRegisterType <em>Register Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Register Type</em>'.
	 * @see it.naturtalent.archiv.model.archive.Ordner#getRegisterType()
	 * @see #getOrdner()
	 * @generated
	 */
	EAttribute getOrdner_RegisterType();

	/**
	 * Returns the meta object for enum '{@link it.naturtalent.archiv.model.archive.RegisterType <em>Register Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Register Type</em>'.
	 * @see it.naturtalent.archiv.model.archive.RegisterType
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
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archive.impl.RegisterImpl <em>Register</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archive.impl.RegisterImpl
		 * @see it.naturtalent.archiv.model.archive.impl.ArchivePackageImpl#getRegister()
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
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archive.impl.OrdnerImpl <em>Ordner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archive.impl.OrdnerImpl
		 * @see it.naturtalent.archiv.model.archive.impl.ArchivePackageImpl#getOrdner()
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
		 * The meta object literal for the '{@link it.naturtalent.archiv.model.archive.RegisterType <em>Register Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.naturtalent.archiv.model.archive.RegisterType
		 * @see it.naturtalent.archiv.model.archive.impl.ArchivePackageImpl#getRegisterType()
		 * @generated
		 */
		EEnum REGISTER_TYPE = eINSTANCE.getRegisterType();

		/**
		 * The meta object literal for the '<em>Empty String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see it.naturtalent.archiv.model.archive.impl.ArchivePackageImpl#getEmptyString()
		 * @generated
		 */
		EDataType EMPTY_STRING = eINSTANCE.getEmptyString();

	}

} //ArchivePackage
