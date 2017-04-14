/**
 */
package it.naturtalent.archiv.model.archive;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.naturtalent.archiv.model.archive.Ordner#getLabel <em>Label</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archive.Ordner#getRegisters <em>Registers</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archive.Ordner#getRegisterType <em>Register Type</em>}</li>
 * </ul>
 *
 * @see it.naturtalent.archiv.model.archive.ArchivePackage#getOrdner()
 * @model
 * @generated
 */
public interface Ordner extends EObject
{
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see it.naturtalent.archiv.model.archive.ArchivePackage#getOrdner_Label()
	 * @model default="" dataType="it.naturtalent.archiv.model.archive.EmptyString"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archive.Ordner#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Registers</b></em>' containment reference list.
	 * The list contents are of type {@link it.naturtalent.archiv.model.archive.Register}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers</em>' containment reference list.
	 * @see it.naturtalent.archiv.model.archive.ArchivePackage#getOrdner_Registers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Register> getRegisters();

	/**
	 * Returns the value of the '<em><b>Register Type</b></em>' attribute.
	 * The literals are from the enumeration {@link it.naturtalent.archiv.model.archive.RegisterType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Register Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Register Type</em>' attribute.
	 * @see it.naturtalent.archiv.model.archive.RegisterType
	 * @see #setRegisterType(RegisterType)
	 * @see it.naturtalent.archiv.model.archive.ArchivePackage#getOrdner_RegisterType()
	 * @model
	 * @generated
	 */
	RegisterType getRegisterType();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archive.Ordner#getRegisterType <em>Register Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Register Type</em>' attribute.
	 * @see it.naturtalent.archiv.model.archive.RegisterType
	 * @see #getRegisterType()
	 * @generated
	 */
	void setRegisterType(RegisterType value);

} // Ordner
