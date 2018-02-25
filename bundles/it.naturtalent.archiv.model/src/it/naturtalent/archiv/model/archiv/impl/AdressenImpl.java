/**
 */
package it.naturtalent.archiv.model.archiv.impl;

import it.naturtalent.archiv.model.archiv.Adresse;
import it.naturtalent.archiv.model.archiv.Adressen;
import it.naturtalent.archiv.model.archiv.ArchivPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adressen</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.naturtalent.archiv.model.archiv.impl.AdressenImpl#getAdresse <em>Adresse</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdressenImpl extends MinimalEObjectImpl.Container implements Adressen
{
	/**
	 * The cached value of the '{@link #getAdresse() <em>Adresse</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdresse()
	 * @generated
	 * @ordered
	 */
	protected EList<Adresse> adresse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdressenImpl()
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
		return ArchivPackage.Literals.ADRESSEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Adresse> getAdresse()
	{
		if (adresse == null)
		{
			adresse = new EObjectContainmentEList<Adresse>(Adresse.class, this, ArchivPackage.ADRESSEN__ADRESSE);
		}
		return adresse;
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
			case ArchivPackage.ADRESSEN__ADRESSE:
				return ((InternalEList<?>)getAdresse()).basicRemove(otherEnd, msgs);
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
			case ArchivPackage.ADRESSEN__ADRESSE:
				return getAdresse();
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
			case ArchivPackage.ADRESSEN__ADRESSE:
				getAdresse().clear();
				getAdresse().addAll((Collection<? extends Adresse>)newValue);
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
			case ArchivPackage.ADRESSEN__ADRESSE:
				getAdresse().clear();
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
			case ArchivPackage.ADRESSEN__ADRESSE:
				return adresse != null && !adresse.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AdressenImpl
