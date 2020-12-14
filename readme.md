# Sensei Cookbook index

This repo contains a list of quality coding pattern cookbooks that you can use with [Sensei](https://sensei-docs-beta.securecodewarrior.com).

## About

[Sensei](https://www.securecodewarrior.com/sensei) is a free IntelliJ plugin from Secure Code Warrior
that helps you create quality coding recipes with Quick Fix transformations to improve your code. [Read more about Sensei in the official documentation](https://sensei-docs-beta.securecodewarrior.com)

[How to add a cookbook](howto.md)

## Cookbooks (2)

<details><summary><strong>Basic security set (49 recipes)</strong>

_Cookbook which can be used as a starting point for security_ | [download .zip](https://sensei-cookbook-registry.nonprod.securecodewarrior.com/securecodewarrior/security/basic-protection-set.zip)</summary>

This cookbook contains a set of low effort recipes that can be used to detect, fix and prevent common recurring critical and high severity vulnerabilities. Enabling this cookbook will set a security baseline. The expected outcome from this cookbook is not to fix issues that are currently present in the codebase. Because we expect that these flaws have been detected by existing security measures such as peer reviews, penetration tests, and SAST tools. The main purpose is that we prevent new instances of these issues from being introduced in the codebase. Because catching these typical flaws late during development or even in production would increase the cost and time of fixing the issues significantly. Overall, this cookbook gives you the opportunity to improve the state of security by preventing the reappearance from common flaws.

#### org.yaml.snakeyaml

Protection against code injection

- org.yaml.snakeyaml.Yaml

#### java.sql

Protection against sql injection

- java.sql.Statement
- java.sql.Connection

#### java.xml

Protection against XML External Entities/Entity Expansion

- javax.xml.parsers.DocumentBuilderFactory
- javax.xml.parsers.SAXParserFactory
- javax.xml.transform.TransformerFactory
- javax.xml.validation.SchemaFactory
- javax.xml.xpath.XPathFactory

<details><summary><strong>Basic Protection Set Recipes List</strong></summary>

[Basic Protection Set Recipes Github](https://github.com/SecureCodeWarrior/cookbook-basic-protection-set)

- Crypto: Cipher: Insecure Asymmetric Cryptographic Algorithm 
    - _This cryptographic algorithm is not recommended_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use strong symmetric cryptographic algorithm 
    - _Could lead to cryptographic weakness_
- Crypto: KeyAgreement: Insecure Cryptographic Algorithm 
    - _This cryptographic algorithm is insecure_
- Crypto: KeyAgreement: Guide on Approved Cryptographic Algorithm
    - _This cryptographic algorithm is not recommended_
- Crypto: KeyPair Generation: Insecure Cryptographic Algorithm 
    - _This cryptographic algorithm is insecure_
- Crypto: KeyPair Generation: Non Standard Cryptographic Algorithm 
    - _This cryptographic algorithm is not recommended_
- Crypto: KeyPair Generation: Approved Standard Cryptographic Algorithm 
    - _This cryptographic algorithm is not recommended_
- Crypto: Signature: Insecure Hashing Algorithm 
    - _This hashing algorithm is not recommended for cryptographic use_
- Crypto: Signature: Non Standard Hashing Algorithm 
    - _This hashing algorithm is not recommended for cryptographic use_
- Crypto: Signature: Approved Hashing Algorithm
    - _This hashing algorithm is not recommended for cryptographic use_
- Data Protection - Cryptography: Avoid brute forcing: Use sufficiently long key sizes: keyGenerator 
    - _Could lead to brute forcing or other cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use sufficiently long key sizes: keyGenerator bad value
    - _Could lead to brute forcing or other cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate key pair generation algorithm: insecure 
    - _Could lead to cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate key pair generation algorithm: not recommended 
    - _Could lead to cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: DES family 
    - _Could lead to cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: Hmac family 
    - _Could lead to cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: Hmac family 1
    - _Could lead to cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: Other algorithms 
    - _Could lead to cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: insecure SecretKeyFactory 
    - _Could lead to cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: not recommended SecretKeyFactory 
    - _This cryptographic algorithm is not recommended_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: other SecretKeyFactory 
    - _Could lead to cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use sufficiently long key sizes: keyPairGenerator 
    - _Could lead to brute forcing or other cryptographic weakness_
- Data Protection - Cryptography: Avoid cryptographic weakness: Use sufficiently long key sizes: keyPairGenerator bad value 
    - _Could lead to brute forcing or other cryptographic weakness_
- Data Protection - Secure Data Storage: Avoid data exposure: Use Cipher instead of NullCipher 
    - _Could lead to data exposure_
- Data: Injection: Parameterize LDAP Filters: DirContext#search
    - _Could lead to LDAP Injection_
- Portability Flaw: Avoid locale dependent comparisons: equals after case conversion
    - _Could behave differently based on the systems locale_
- TLS: Weak Encryption: Insecure Version 
    - _Could lead to Data Exposure_
- TLS: Weak Encryption: Outdated Version
    - _Could lead to Data Exposure_
- Injection: Avoid XML Injection: Use setSchema 
    - _Could lead to XML Injection_
- Injection: Avoid XML Injection: Use setFeature 
    - _Could lead to XML Injection_
- Injection: Avoid XML Injection: setFeature with bad value
    - _Could lead to XML Injection_
- Input Validation: Avoid XXE: Do not set DocumentBuilderFactory external-parameter-entities to true 
    - _Could lead to XXE_
- Input Validation: Avoid XXE: Do not set DocumentBuilderFactory load-external-dtd to true 
    - _Could lead to XXE_
- Input Validation: Avoid XXE: Do not set DocumentBuilderFactory setXIncludeAware to true 
    - _Could lead to XXE_
- Input Validation: Avoid XXE: Do not set DocumentBuilderFactory setExpandEntityReferences to true 
    - _Could lead to XXE_
- InputValidation: Avoid XXE: Do not set XMLInputFactory Property to true 
    - _Could lead to XXE_
- XML External Entities: DocumentBuilderFactory setExpandEntityReferences: to false 
    - _Could lead to XXE_
- XML External Entities: DocumentBuilderFactory setFeature: dissallow-doctype-decl 
    - _Could lead to XXE_
- XML External Entities: DocumentBuilderFactory setFeature: external-parameter-entities should be set first 
    - _Could lead to XXE_
- XML External Entities: DocumentBuilderFactory setFeature: load-external-dtd 
    - _Could lead to XXE_
- XML External Entities: DocumentBuilderFactory setXIncludeAware 
    - _Could lead to XXE_
- XML External Entities: DocumentBuilderFactory setFeature: dissallow-doctype-decl wrong boolean 
    - _Could lead to XXE_
- XML External Entities: XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES
    - _Could lead to XXE_
- XML External Entities: XMLInputFactory.SUPPORT_DTD
    - _Could lead to XXE_
- Injection: Avoid SQL Injection: Use Parameterized Queries (PreparedStatement)
    - _Could lead to SQL Injection_
- Injection: Avoid SQL Injection: Use Parameterized Queries (Statement)
    - _Could lead to SQL Injection_
- Injection: Avoid Code Injection: Use SafeConstructor: no arguments
    - _Could lead to Remote Code Execution_
- Injection: Avoid Code Injection: Use SafeConstructor: 1st argument of type Constructor
    - _Could lead to Remote Code Execution_
- Injection: Avoid Code Injection: Use SafeConstructor: arguments, but no Constructor argument
    - _Could lead to Remote Code Execution_
</details>

</details>

<details><summary><strong>Sensei Blog examples</strong>


_All the recipes that are showcased in the [Sensei blog examples](https://github.com/SecureCodeWarrior/sensei-blog-examples)_ | [download .zip](https://sensei-cookbook-registry.nonprod.securecodewarrior.com/securecodewarrior/blog-examples/sensei-blog-examples.zip)</summary>


#### Contents

- POJO
    - Converting System.out.println to using a Logger
    - Adding a Private Constructor to a Utility Class
    - Basic Immutability
- JUnit 5
    - Adding and Removing Annotations
    - Adding Parameters to Annotations
    - Creating Library Documentation Links to Tutorials and Examples
    - Amending Visibility Modifiers of Methods and Classes
- Guice
    - Detecting Forgotten Guice Dependency Injection Wiring
- SQL Injection Fixes
    - Fix SQL Injection Vulnerability

<details><summary><strong>Blog Examples List (19 recipes)</strong></summary>

[Sensei Blog Examples Recipes Github](https://github.com/SecureCodeWarrior/sensei-blog-examples)

- JUnit: Make @Disabled @Test from SKIPTHIS
    - _Stop naming methods SKIPTHIS, use @Disabled @Test instead_
- JUnit: in SkipThisTest remove @Disabled and revert to SKIPTHIS
    - _remove @Disabled and revert to SKIPTHIS for demo purposes in the project_
- Logger: use logger instead of println
    - _use logger instead of println - remember stop using System.out.println_
- Logger: add logger
    - _Add logger to class_
- remember to add disabled description
    - _@Disabled should really have a description explaining why_
- Junit docs link
    - _Learn about JUnit @Test method_
- learn about parameterized tests
    - _learn about parameterized tests_
- Static Classes: create private constructor
    - _create a private constructor for static classes_
- Test Classes in JUnit 5 do not need to be public
    - _Test Classes in JUnit 5 do not need to be public_
- JUnit: JUnit 5 test methods do not need to be public
    - _JUnit 5 test methods do not need public visibility_
- Guice Injected Field Not Public
    - _If the Injected field is not public then the code might not be wired up._
- sql injection - use a parameterized query
    - _execute query with untrusted inputs is vulnerable to SQL Injection_
- Immutable: use final classes to prevent extension
    - _Make the classes final to prevent people extending as mutable_
- JUnit: Junit 5 Test classes do not need to be public
    - _Junit 5 Test classes do not need to be public_
- Immutable: Fields should be final and set in the constructor
    - _Making fields final can highlight mutability issues_
- Immutable: default constructor should set field values from parameters
    - _avoid default constructor and create a private constructor that sets the field values_
- Immutable: delete public void setters
    - _void setters can be replaced with use of constructor or static factory methods_
- Immutable: avoid setters that return values
    - _avoid setters methods that return values_
- Immutable: avoid void methods
    - _void methods have side-effects, return a new object or primitve instead_
</details>

</details>


## Extras

- [Sensei](https://www.securecodewarrior.com/sensei)
- [Sensei in action (video)](https://www.youtube.com/watch?v=mjXGliXJ7M8)
- [Sensei blog examples](https://github.com/SecureCodeWarrior/sensei-blog-examples)
- [Secure Code Warrior](https://www.securecodewarrior.com)
