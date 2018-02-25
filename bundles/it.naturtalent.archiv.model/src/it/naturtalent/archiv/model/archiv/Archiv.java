/**
 */
package it.naturtalent.archiv.model.archiv;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Archiv</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Archiv#getName <em>Name</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Archiv#getOrdner <em>Ordner</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Archiv#getAdresse <em>Adresse</em>}</li>
 * </ul>
 *
 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getArchiv()
 * @model
 * @generated
 */
public interface Archiv extends EObject
{
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
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getArchiv_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archiv.Archiv#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ordner</b></em>' containment reference list.
	 * The list contents are of type {@link it.naturtalent.archiv.model.archiv.Ordner}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordner</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordner</em>' containment reference list.
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getArchiv_Ordner()
	 * @model containment="true"
	 * @generated
	 */
	EList<Ordner> getOrdner();

	/**
	 * Returns the value of the '<em><b>Adresse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adresse</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adresse</em>' reference.
	 * @see #setAdresse(Adresse)
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getArchiv_Adresse()
	 * @model
	 * @generated
	 */
	Adresse getAdresse();

	/**
	 * Sets the value of the '{@link it.naturtalent.archiv.model.archiv.Archiv#getAdresse <em>Adresse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adresse</em>' reference.
	 * @see #getAdresse()
	 * @generated
	 */
	void setAdresse(Adresse value);

} // Archiv
