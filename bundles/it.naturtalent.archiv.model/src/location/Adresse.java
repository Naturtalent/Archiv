/**
 */
package location;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adresse</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link location.Adresse#getStrasse <em>Strasse</em>}</li>
 *   <li>{@link location.Adresse#getNummer <em>Nummer</em>}</li>
 *   <li>{@link location.Adresse#getZusatz <em>Zusatz</em>}</li>
 *   <li>{@link location.Adresse#getPlz <em>Plz</em>}</li>
 *   <li>{@link location.Adresse#getOrt <em>Ort</em>}</li>
 * </ul>
 *
 * @see location.LocationPackage#getAdresse()
 * @model
 * @generated
 */
public interface Adresse extends EObject
{
	/**
	 * Returns the value of the '<em><b>Strasse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strasse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strasse</em>' attribute.
	 * @see #setStrasse(String)
	 * @see location.LocationPackage#getAdresse_Strasse()
	 * @model
	 * @generated
	 */
	String getStrasse();

	/**
	 * Sets the value of the '{@link location.Adresse#getStrasse <em>Strasse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strasse</em>' attribute.
	 * @see #getStrasse()
	 * @generated
	 */
	void setStrasse(String value);

	/**
	 * Returns the value of the '<em><b>Nummer</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nummer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nummer</em>' attribute.
	 * @see #setNummer(String)
	 * @see location.LocationPackage#getAdresse_Nummer()
	 * @model default=""
	 * @generated
	 */
	String getNummer();

	/**
	 * Sets the value of the '{@link location.Adresse#getNummer <em>Nummer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nummer</em>' attribute.
	 * @see #getNummer()
	 * @generated
	 */
	void setNummer(String value);

	/**
	 * Returns the value of the '<em><b>Zusatz</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zusatz</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zusatz</em>' attribute.
	 * @see #setZusatz(String)
	 * @see location.LocationPackage#getAdresse_Zusatz()
	 * @model default=""
	 * @generated
	 */
	String getZusatz();

	/**
	 * Sets the value of the '{@link location.Adresse#getZusatz <em>Zusatz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zusatz</em>' attribute.
	 * @see #getZusatz()
	 * @generated
	 */
	void setZusatz(String value);

	/**
	 * Returns the value of the '<em><b>Plz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plz</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plz</em>' attribute.
	 * @see #setPlz(String)
	 * @see location.LocationPackage#getAdresse_Plz()
	 * @model
	 * @generated
	 */
	String getPlz();

	/**
	 * Sets the value of the '{@link location.Adresse#getPlz <em>Plz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plz</em>' attribute.
	 * @see #getPlz()
	 * @generated
	 */
	void setPlz(String value);

	/**
	 * Returns the value of the '<em><b>Ort</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ort</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ort</em>' attribute.
	 * @see #setOrt(String)
	 * @see location.LocationPackage#getAdresse_Ort()
	 * @model default=""
	 * @generated
	 */
	String getOrt();

	/**
	 * Sets the value of the '{@link location.Adresse#getOrt <em>Ort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ort</em>' attribute.
	 * @see #getOrt()
	 * @generated
	 */
	void setOrt(String value);

} // Adresse
