/**
 */
package it.naturtalent.archiv.model.archiv.provider;


import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.swt.graphics.Image;

/**
 * This is the item provider adapter for a {@link it.naturtalent.archiv.model.archiv.Register} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RegisterItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegisterItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addLabelPropertyDescriptor(object);
			addProjectIDPropertyDescriptor(object);
			addCounterPropertyDescriptor(object);
			addNumericDataPropertyDescriptor(object);
			addAlphaDataPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Register_label_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Register_label_feature", "_UI_Register_type"),
				 ArchivPackage.Literals.REGISTER__LABEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Project ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProjectIDPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Register_projectID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Register_projectID_feature", "_UI_Register_type"),
				 ArchivPackage.Literals.REGISTER__PROJECT_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Counter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCounterPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Register_counter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Register_counter_feature", "_UI_Register_type"),
				 ArchivPackage.Literals.REGISTER__COUNTER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Numeric Data feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumericDataPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Register_numericData_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Register_numericData_feature", "_UI_Register_type"),
				 ArchivPackage.Literals.REGISTER__NUMERIC_DATA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Alpha Data feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlphaDataPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Register_alphaData_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Register_alphaData_feature", "_UI_Register_type"),
				 ArchivPackage.Literals.REGISTER__ALPHA_DATA,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Register.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object)
	{
		//return overlayImage(object, getResourceLocator().getImage("full/obj16/Register"));
		//return overlayImage(object, getResourceLocator().getImage("full/obj16/page.png"));
		
		Object image = overlayImage(object, getResourceLocator().getImage("full/obj16/page.png"));				
		if (object instanceof Register)
		{
			Register register = (Register) object;

			String projectID = register.getProjectID(); 
			if(StringUtils.isNotEmpty(projectID))
			{				
				List<Object> images = new ArrayList<Object>(2);
				images.add(image);					
				Object ovr = Icon.OVERLAY_PROJECT_CO.getImage(IconSize._7x8_OverlayIconSize);
				images.add(ovr);		
				images.add(EMFEditPlugin.INSTANCE.getImage("full/ovr16/ControlledObject"));
				image = new ComposedImage(images);
			}
		}
		
		return image;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object)
	{
		String label = getString("_UI_Register_type");
		
		Register register = (Register)object;
		Ordner ordner = (Ordner) register.eContainer();
		
		String stgRegister = "";
		switch (ordner.getRegisterType())
		{
			case NUMERIC_TYPE:
				NumberFormat numberFormatter = new DecimalFormat("##00");
				stgRegister = numberFormatter.format(((Register)object).getNumericData());
				break;
				
			case LETTER_TYPE:
				stgRegister = register.getAlphaData();
				break;
				
			case STRING_TYPE:
				stgRegister = register.getLabel();
				break;
								
			default:
				break;
		}

		return label+" "+stgRegister;
		
		/*
		String label = ((Register)object).getLabel();
		return label == null || label.length() == 0 ?
			getString("_UI_Register_type") :
			getString("_UI_Register_type") + " " + label;
			*/
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);

		switch (notification.getFeatureID(Register.class))
		{
			case ArchivPackage.REGISTER__LABEL:
			case ArchivPackage.REGISTER__PROJECT_ID:
			case ArchivPackage.REGISTER__COUNTER:
			case ArchivPackage.REGISTER__NUMERIC_DATA:
			case ArchivPackage.REGISTER__ALPHA_DATA:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
	{
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		return ArchivEditPlugin.INSTANCE;
	}

}
