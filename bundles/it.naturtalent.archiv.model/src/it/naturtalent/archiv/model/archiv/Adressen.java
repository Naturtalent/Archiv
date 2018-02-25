/**
 */
package it.naturtalent.archiv.model.archiv;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adressen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.naturtalent.archiv.model.archiv.Adressen#getAdresse <em>Adresse</em>}</li>
 * </ul>
 *
 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getAdressen()
 * @model
 * @generated
 */
public interface Adressen extends EObject
{
	/**
	 * Returns the value of the '<em><b>Adresse</b></em>' containment reference list.
	 * The list contents are of type {@link it.naturtalent.archiv.model.archiv.Adresse}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adresse</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adresse</em>' containment reference list.
	 * @see it.naturtalent.archiv.model.archiv.ArchivPackage#getAdressen_Adresse()
	 * @model containment="true"
	 * @generated
	 */
	EList<Adresse> getAdresse();

} // Adressen
