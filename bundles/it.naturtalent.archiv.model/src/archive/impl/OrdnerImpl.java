/**
 */
package archive.impl;

import archive.Archiv;
import archive.ArchivePackage;
import archive.Ordner;
import archive.Register;
import archive.RegisterType;

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
 * An implementation of the model object '<em><b>Ordner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link archive.impl.OrdnerImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link archive.impl.OrdnerImpl#getRegisters <em>Registers</em>}</li>
 *   <li>{@link archive.impl.OrdnerImpl#getRegisterType <em>Register Type</em>}</li>
 *   <li>{@link archive.impl.OrdnerImpl#getArchiv <em>Archiv</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrdnerImpl extends MinimalEObjectImpl.Container implements Ordner
{
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRegisters() <em>Registers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisters()
	 * @generated
	 * @ordered
	 */
	protected EList<Register> registers;

	/**
	 * The default value of the '{@link #getRegisterType() <em>Register Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisterType()
	 * @generated
	 * @ordered
	 */
	protected static final RegisterType REGISTER_TYPE_EDEFAULT = RegisterType.NUMERIC_TYPE;

	/**
	 * The cached value of the '{@link #getRegisterType() <em>Register Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisterType()
	 * @generated
	 * @ordered
	 */
	protected RegisterType registerType = REGISTER_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArchiv() <em>Archiv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchiv()
	 * @generated
	 * @ordered
	 */
	protected Archiv archiv;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrdnerImpl()
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
		return ArchivePackage.Literals.ORDNER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel)
	{
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivePackage.ORDNER__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Register> getRegisters()
	{
		if (registers == null)
		{
			registers = new EObjectContainmentEList<Register>(Register.class, this, ArchivePackage.ORDNER__REGISTERS);
		}
		return registers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegisterType getRegisterType()
	{
		return registerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegisterType(RegisterType newRegisterType)
	{
		RegisterType oldRegisterType = registerType;
		registerType = newRegisterType == null ? REGISTER_TYPE_EDEFAULT : newRegisterType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivePackage.ORDNER__REGISTER_TYPE, oldRegisterType, registerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Archiv getArchiv()
	{
		if (archiv != null && archiv.eIsProxy())
		{
			InternalEObject oldArchiv = (InternalEObject)archiv;
			archiv = (Archiv)eResolveProxy(oldArchiv);
			if (archiv != oldArchiv)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchivePackage.ORDNER__ARCHIV, oldArchiv, archiv));
			}
		}
		return archiv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Archiv basicGetArchiv()
	{
		return archiv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArchiv(Archiv newArchiv)
	{
		Archiv oldArchiv = archiv;
		archiv = newArchiv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchivePackage.ORDNER__ARCHIV, oldArchiv, archiv));
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
			case ArchivePackage.ORDNER__REGISTERS:
				return ((InternalEList<?>)getRegisters()).basicRemove(otherEnd, msgs);
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
			case ArchivePackage.ORDNER__LABEL:
				return getLabel();
			case ArchivePackage.ORDNER__REGISTERS:
				return getRegisters();
			case ArchivePackage.ORDNER__REGISTER_TYPE:
				return getRegisterType();
			case ArchivePackage.ORDNER__ARCHIV:
				if (resolve) return getArchiv();
				return basicGetArchiv();
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
			case ArchivePackage.ORDNER__LABEL:
				setLabel((String)newValue);
				return;
			case ArchivePackage.ORDNER__REGISTERS:
				getRegisters().clear();
				getRegisters().addAll((Collection<? extends Register>)newValue);
				return;
			case ArchivePackage.ORDNER__REGISTER_TYPE:
				setRegisterType((RegisterType)newValue);
				return;
			case ArchivePackage.ORDNER__ARCHIV:
				setArchiv((Archiv)newValue);
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
			case ArchivePackage.ORDNER__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case ArchivePackage.ORDNER__REGISTERS:
				getRegisters().clear();
				return;
			case ArchivePackage.ORDNER__REGISTER_TYPE:
				setRegisterType(REGISTER_TYPE_EDEFAULT);
				return;
			case ArchivePackage.ORDNER__ARCHIV:
				setArchiv((Archiv)null);
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
			case ArchivePackage.ORDNER__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case ArchivePackage.ORDNER__REGISTERS:
				return registers != null && !registers.isEmpty();
			case ArchivePackage.ORDNER__REGISTER_TYPE:
				return registerType != REGISTER_TYPE_EDEFAULT;
			case ArchivePackage.ORDNER__ARCHIV:
				return archiv != null;
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
		result.append(" (label: ");
		result.append(label);
		result.append(", registerType: ");
		result.append(registerType);
		result.append(')');
		return result.toString();
	}

} //OrdnerImpl
