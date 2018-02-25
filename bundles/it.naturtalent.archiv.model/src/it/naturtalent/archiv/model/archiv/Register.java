/**
 */
package it.naturtalent.archiv.model.archiv;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Register</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Register#getLabel <em>Label</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Register#getProjectID <em>Project ID</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Register#getCounter <em>Counter</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Register#getNumericData <em>Numeric Data</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Register#getAlphaData <em>Alpha Data</em>}</li>
 * </ul>
 *
 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getRegister()
 * @model
 * @generated
 */
public interface Register extends EObject
{
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getRegister_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archiv.Register#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Project ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project ID</em>' attribute.
	 * @see #setProjectID(String)
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getRegister_ProjectID()
	 * @model
	 * @generated
	 */
	String getProjectID();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archiv.Register#getProjectID <em>Project ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project ID</em>' attribute.
	 * @see #getProjectID()
	 * @generated
	 */
	void setProjectID(String value);

	/**
	 * Returns the value of the '<em><b>Counter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Counter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Counter</em>' attribute.
	 * @see #setCounter(short)
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getRegister_Counter()
	 * @model
	 * @generated
	 */
	short getCounter();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archiv.Register#getCounter <em>Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Counter</em>' attribute.
	 * @see #getCounter()
	 * @generated
	 */
	void setCounter(short value);

	/**
	 * Returns the value of the '<em><b>Numeric Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numeric Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numeric Data</em>' attribute.
	 * @see #setNumericData(short)
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getRegister_NumericData()
	 * @model
	 * @generated
	 */
	short getNumericData();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archiv.Register#getNumericData <em>Numeric Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numeric Data</em>' attribute.
	 * @see #getNumericData()
	 * @generated
	 */
	void setNumericData(short value);

	/**
	 * Returns the value of the '<em><b>Alpha Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alpha Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alpha Data</em>' attribute.
	 * @see #setAlphaData(String)
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getRegister_AlphaData()
	 * @model
	 * @generated
	 */
	String getAlphaData();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archiv.Register#getAlphaData <em>Alpha Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alpha Data</em>' attribute.
	 * @see #getAlphaData()
	 * @generated
	 */
	void setAlphaData(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasName(DiagnosticChain chain, Map<?, ?> context);

} // Register
