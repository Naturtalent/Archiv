/**
 */
package it.naturtalent.archiv.model.archiv;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see it.naturtalent.archiv.model.archiv.ArchivPackage
 * @generated
 */
public interface ArchivFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchivFactory eINSTANCE = it.naturtalent.archiv.model.archiv.impl.ArchivFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Register</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Register</em>'.
	 * @generated
	 */
	Register createRegister();

	/**
	 * Returns a new object of class '<em>Ordner</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ordner</em>'.
	 * @generated
	 */
	Ordner createOrdner();

	/**
	 * Returns a new object of class '<em>Archiv</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Archiv</em>'.
	 * @generated
	 */
	Archiv createArchiv();

	/**
	 * Returns a new object of class '<em>Archive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Archive</em>'.
	 * @generated
	 */
	Archive createArchive();

	/**
	 * Returns a new object of class '<em>Adresse</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adresse</em>'.
	 * @generated
	 */
	Adresse createAdresse();

	/**
	 * Returns a new object of class '<em>Adressen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adressen</em>'.
	 * @generated
	 */
	Adressen createAdressen();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ArchivPackage getArchivPackage();

} //ArchivFactory
