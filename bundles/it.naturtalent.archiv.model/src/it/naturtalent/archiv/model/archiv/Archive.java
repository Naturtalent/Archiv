/**
 */
package it.naturtalent.archiv.model.archiv;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Archive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Archive#getArchiv <em>Archiv</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Archive#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getArchive()
 * @model
 * @generated
 */
public interface Archive extends EObject
{
	/**
	 * Returns the value of the '<em><b>Archiv</b></em>' containment reference list.
	 * The list contents are of type {@link it.naturtalent.archiv.model.archiv.Archiv}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Archiv</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Archiv</em>' containment reference list.
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getArchive_Archiv()
	 * @model containment="true"
	 * @generated
	 */
	EList<Archiv> getArchiv();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getArchive_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archiv.Archive#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Archive
