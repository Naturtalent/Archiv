/**
 */
package it.naturtalent.archiv.model.archiv.impl;

import it.naturtalent.archiv.model.archiv.Adresse;
import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Ordner;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Archiv</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.naturtalent.archiv.model.archiv.impl.ArchivImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archiv.impl.ArchivImpl#getOrdner <em>Ordner</em>}</li>
 *   <li>{@link it.naturtalent.archiv.model.archiv.impl.ArchivImpl#getAdresse <em>Adresse</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArchivImpl extends MinimalEObjectImpl.Container implements Archiv
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOrdner() <em>Ordner</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrdner()
	 * @generated
	 * @ordered
	 */
	protected EList<Ordner> ordner;

	/**
	 * The cached value of the '{@link #getAdresse() <em>Adresse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdresse()
	 * @generated
	 * @ordered
	 */
	protected Adresse adresse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchivImpl()
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
		return ArchivPackage.Literals.ARCHIV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivPackage.ARCHIV__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Ordner> getOrdner()
	{
		if (ordner == null)
		{
			ordner = new EObjectContainmentEList<Ordner>(Ordner.class, this, ArchivPackage.ARCHIV__ORDNER);
		}
		return ordner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adresse getAdresse()
	{
		if (adresse != null && adresse.eIsProxy())
		{
			InternalEObject oldAdresse = (InternalEObject)adresse;
			adresse = (Adresse)eResolveProxy(oldAdresse);
			if (adresse != oldAdresse)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchivPackage.ARCHIV__ADRESSE, oldAdresse, adresse));
			}
		}
		return adresse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adresse basicGetAdresse()
	{
		return adresse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdresse(Adresse newAdresse)
	{
		Adresse oldAdresse = adresse;
		adresse = newAdresse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivPackage.ARCHIV__ADRESSE, oldAdresse, adresse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ArchivPackage.ARCHIV__ORDNER:
				return ((InternalEList<?>)getOrdner()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ArchivPackage.ARCHIV__NAME:
				return getName();
			case ArchivPackage.ARCHIV__ORDNER:
				return getOrdner();
			case ArchivPackage.ARCHIV__ADRESSE:
				if (resolve) return getAdresse();
				return basicGetAdresse();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ArchivPackage.ARCHIV__NAME:
				setName((String)newValue);
				return;
			case ArchivPackage.ARCHIV__ORDNER:
				getOrdner().clear();
				getOrdner().addAll((Collection<? extends Ordner>)newValue);
				return;
			case ArchivPackage.ARCHIV__ADRESSE:
				setAdresse((Adresse)newValue);
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
			case ArchivPackage.ARCHIV__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArchivPackage.ARCHIV__ORDNER:
				getOrdner().clear();
				return;
			case ArchivPackage.ARCHIV__ADRESSE:
				setAdresse((Adresse)null);
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
			case ArchivPackage.ARCHIV__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArchivPackage.ARCHIV__ORDNER:
				return ordner != null && !ordner.isEmpty();
			case ArchivPackage.ARCHIV__ADRESSE:
				return adresse != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ArchivImpl
