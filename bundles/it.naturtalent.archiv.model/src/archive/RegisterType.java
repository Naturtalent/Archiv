/**
 */
package archive;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Register Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see archive.ArchivePackage#getRegisterType()
 * @model
 * @generated
 */
public enum RegisterType implements Enumerator
{
	/**
	 * The '<em><b>Numeric Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	NUMERIC_TYPE(1, "NumericType", "Zahlenregister"), /**
	 * The '<em><b>String Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	STRING_TYPE(0, "StringType", "Blankregister"),

	/**
	 * The '<em><b>Letter Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LETTER_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	LETTER_TYPE(2, "LetterType", "Buchstabenregister");

	/**
	 * The '<em><b>Numeric Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Numeric Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NUMERIC_TYPE
	 * @model name="NumericType" literal="Zahlenregister"
	 * @generated
	 * @ordered
	 */
	public static final int NUMERIC_TYPE_VALUE = 1;

	/**
	 * The '<em><b>String Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>String Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING_TYPE
	 * @model name="StringType" literal="Blankregister"
	 * @generated
	 * @ordered
	 */
	public static final int STRING_TYPE_VALUE = 0;

	/**
	 * The '<em><b>Letter Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Letter Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LETTER_TYPE
	 * @model name="LetterType" literal="Buchstabenregister"
	 * @generated
	 * @ordered
	 */
	public static final int LETTER_TYPE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Register Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RegisterType[] VALUES_ARRAY =
		new RegisterType[]
		{
			NUMERIC_TYPE,
			STRING_TYPE,
			LETTER_TYPE,
		};

	/**
	 * A public read-only list of all the '<em><b>Register Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RegisterType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Register Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RegisterType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			RegisterType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Register Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RegisterType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			RegisterType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Register Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RegisterType get(int value)
	{
		switch (value)
		{
			case NUMERIC_TYPE_VALUE: return NUMERIC_TYPE;
			case STRING_TYPE_VALUE: return STRING_TYPE;
			case LETTER_TYPE_VALUE: return LETTER_TYPE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RegisterType(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
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
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //RegisterType
