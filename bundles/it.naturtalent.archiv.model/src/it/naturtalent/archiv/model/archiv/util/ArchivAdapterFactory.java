/**
 */
package it.naturtalent.archiv.model.archiv.util;

import it.naturtalent.archiv.model.archiv.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see it.naturtalent.archiv.model.archiv.ArchivPackage
 * @generated
 */
public class ArchivAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ArchivPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchivAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = ArchivPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchivSwitch<Adapter> modelSwitch =
		new ArchivSwitch<Adapter>()
		{
			@Override
			public Adapter caseRegister(Register object)
			{
				return createRegisterAdapter();
			}
			@Override
			public Adapter caseOrdner(Ordner object)
			{
				return createOrdnerAdapter();
			}
			@Override
			public Adapter caseArchiv(Archiv object)
			{
				return createArchivAdapter();
			}
			@Override
			public Adapter caseArchive(Archive object)
			{
				return createArchiveAdapter();
			}
			@Override
			public Adapter caseAdresse(Adresse object)
			{
				return createAdresseAdapter();
			}
			@Override
			public Adapter caseAdressen(Adressen object)
			{
				return createAdressenAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link it.naturtalent.archiv.model.archiv.Register <em>Register</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see it.naturtalent.archiv.model.archiv.Register
	 * @generated
	 */
	public Adapter createRegisterAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link it.naturtalent.archiv.model.archiv.Ordner <em>Ordner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see it.naturtalent.archiv.model.archiv.Ordner
	 * @generated
	 */
	public Adapter createOrdnerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link it.naturtalent.archiv.model.archiv.Archiv <em>Archiv</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see it.naturtalent.archiv.model.archiv.Archiv
	 * @generated
	 */
	public Adapter createArchivAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link it.naturtalent.archiv.model.archiv.Archive <em>Archive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see it.naturtalent.archiv.model.archiv.Archive
	 * @generated
	 */
	public Adapter createArchiveAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link it.naturtalent.archiv.model.archiv.Adresse <em>Adresse</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see it.naturtalent.archiv.model.archiv.Adresse
	 * @generated
	 */
	public Adapter createAdresseAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link it.naturtalent.archiv.model.archiv.Adressen <em>Adressen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see it.naturtalent.archiv.model.archiv.Adressen
	 * @generated
	 */
	public Adapter createAdressenAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //ArchivAdapterFactory
