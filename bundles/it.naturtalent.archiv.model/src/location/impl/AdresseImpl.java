/**
 */
package location.impl;

import location.Adresse;
import location.LocationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adresse</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link location.impl.AdresseImpl#getStrasse <em>Strasse</em>}</li>
 *   <li>{@link location.impl.AdresseImpl#getNummer <em>Nummer</em>}</li>
 *   <li>{@link location.impl.AdresseImpl#getZusatz <em>Zusatz</em>}</li>
 *   <li>{@link location.impl.AdresseImpl#getPlz <em>Plz</em>}</li>
 *   <li>{@link location.impl.AdresseImpl#getOrt <em>Ort</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdresseImpl extends MinimalEObjectImpl.Container implements Adresse
{
	/**
	 * The default value of the '{@link #getStrasse() <em>Strasse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrasse()
	 * @generated
	 * @ordered
	 */
	protected static final String STRASSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStrasse() <em>Strasse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrasse()
	 * @generated
	 * @ordered
	 */
	protected String strasse = STRASSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNummer() <em>Nummer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNummer()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMMER_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNummer() <em>Nummer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNummer()
	 * @generated
	 * @ordered
	 */
	protected String nummer = NUMMER_EDEFAULT;

	/**
	 * The default value of the '{@link #getZusatz() <em>Zusatz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZusatz()
	 * @generated
	 * @ordered
	 */
	protected static final String ZUSATZ_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getZusatz() <em>Zusatz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZusatz()
	 * @generated
	 * @ordered
	 */
	protected String zusatz = ZUSATZ_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlz() <em>Plz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlz()
	 * @generated
	 * @ordered
	 */
	protected static final String PLZ_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlz() <em>Plz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlz()
	 * @generated
	 * @ordered
	 */
	protected String plz = PLZ_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrt() <em>Ort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrt()
	 * @generated
	 * @ordered
	 */
	protected static final String ORT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOrt() <em>Ort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrt()
	 * @generated
	 * @ordered
	 */
	protected String ort = ORT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdresseImpl()
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
		return LocationPackage.Literals.ADRESSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStrasse()
	{
		return strasse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrasse(String newStrasse)
	{
		String oldStrasse = strasse;
		strasse = newStrasse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.ADRESSE__STRASSE, oldStrasse, strasse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNummer()
	{
		return nummer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNummer(String newNummer)
	{
		String oldNummer = nummer;
		nummer = newNummer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.ADRESSE__NUMMER, oldNummer, nummer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZusatz()
	{
		return zusatz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZusatz(String newZusatz)
	{
		String oldZusatz = zusatz;
		zusatz = newZusatz;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.ADRESSE__ZUSATZ, oldZusatz, zusatz));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlz()
	{
		return plz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlz(String newPlz)
	{
		String oldPlz = plz;
		plz = newPlz;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.ADRESSE__PLZ, oldPlz, plz));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrt()
	{
		return ort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrt(String newOrt)
	{
		String oldOrt = ort;
		ort = newOrt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.ADRESSE__ORT, oldOrt, ort));
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
			case LocationPackage.ADRESSE__STRASSE:
				return getStrasse();
			case LocationPackage.ADRESSE__NUMMER:
				return getNummer();
			case LocationPackage.ADRESSE__ZUSATZ:
				return getZusatz();
			case LocationPackage.ADRESSE__PLZ:
				return getPlz();
			case LocationPackage.ADRESSE__ORT:
				return getOrt();
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
			case LocationPackage.ADRESSE__STRASSE:
				setStrasse((String)newValue);
				return;
			case LocationPackage.ADRESSE__NUMMER:
				setNummer((String)newValue);
				return;
			case LocationPackage.ADRESSE__ZUSATZ:
				setZusatz((String)newValue);
				return;
			case LocationPackage.ADRESSE__PLZ:
				setPlz((String)newValue);
				return;
			case LocationPackage.ADRESSE__ORT:
				setOrt((String)newValue);
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
			case LocationPackage.ADRESSE__STRASSE:
				setStrasse(STRASSE_EDEFAULT);
				return;
			case LocationPackage.ADRESSE__NUMMER:
				setNummer(NUMMER_EDEFAULT);
				return;
			case LocationPackage.ADRESSE__ZUSATZ:
				setZusatz(ZUSATZ_EDEFAULT);
				return;
			case LocationPackage.ADRESSE__PLZ:
				setPlz(PLZ_EDEFAULT);
				return;
			case LocationPackage.ADRESSE__ORT:
				setOrt(ORT_EDEFAULT);
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
			case LocationPackage.ADRESSE__STRASSE:
				return STRASSE_EDEFAULT == null ? strasse != null : !STRASSE_EDEFAULT.equals(strasse);
			case LocationPackage.ADRESSE__NUMMER:
				return NUMMER_EDEFAULT == null ? nummer != null : !NUMMER_EDEFAULT.equals(nummer);
			case LocationPackage.ADRESSE__ZUSATZ:
				return ZUSATZ_EDEFAULT == null ? zusatz != null : !ZUSATZ_EDEFAULT.equals(zusatz);
			case LocationPackage.ADRESSE__PLZ:
				return PLZ_EDEFAULT == null ? plz != null : !PLZ_EDEFAULT.equals(plz);
			case LocationPackage.ADRESSE__ORT:
				return ORT_EDEFAULT == null ? ort != null : !ORT_EDEFAULT.equals(ort);
		}
		return super.eIsSet(featureID);
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
		result.append(" (strasse: ");
		result.append(strasse);
		result.append(", nummer: ");
		result.append(nummer);
		result.append(", zusatz: ");
		result.append(zusatz);
		result.append(", plz: ");
		result.append(plz);
		result.append(", ort: ");
		result.append(ort);
		result.append(')');
		return result.toString();
	}

} //AdresseImpl
