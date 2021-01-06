# Sensei Cookbook index

This repo contains a list of quality coding pattern cookbooks that you can use with [Sensei](https://sensei-docs-beta.securecodewarrior.com).

## About

[Sensei](https://www.securecodewarrior.com/sensei) is a free IntelliJ plugin from Secure Code Warrior
that helps you create quality coding recipes with Quick Fix transformations to improve your code. [Read more about Sensei in the official documentation](https://sensei-docs-beta.securecodewarrior.com)

- [How to add a cookbook to your Sensei install](https://github.com/SecureCodeWarrior/public-cookbooks/wiki/How-to-add-a-cookbook)
- [How to contribute a Cookbook or a Recipe](https://github.com/SecureCodeWarrior/public-cookbooks/wiki/How-to-contribute-cookbooks)

## Cookbooks

<details>
<summary><strong>Basic security set</strong> - external recipe(s) -

<p>Cookbook which can be used as a starting point for security</p>
</summary>

<ul>
<li>49 recipes</li>
<li><a href="https://sensei-cookbook-registry.nonprod.securecodewarrior.com/securecodewarrior/security/basic-protection-set.zip">download .zip</a></li>
<li><a href="https://github.com/SecureCodeWarrior/cookbook-basic-protection-set.git">use .git</a></li>
</ul>

<p>
<em>This cookbook contains a set of low effort recipes that can be used to detect, fix and prevent common recurring critical and high severity vulnerabilities. Enabling this cookbook will set a security baseline. The expected outcome from this cookbook is not to fix issues that are currently present in the codebase. Because we expect that these flaws have been detected by existing security measures such as peer reviews, penetration tests, and SAST tools. The main purpose is that we prevent new instances of these issues from being introduced in the codebase. Because catching these typical flaws late during development or even in production would increase the cost and time of fixing the issues significantly. Overall, this cookbook gives you the opportunity to improve the state of security by preventing the reappearance from common flaws.</em>
</p>

<!--
Protection against code injection

*   org.yaml.snakeyaml.Yaml

Protection against sql injection

*   java.sql.Statement
*   java.sql.Connection

Protection against XML External Entities/Entity Expansion

*   javax.xml.parsers.DocumentBuilderFactory
*   javax.xml.parsers.SAXParserFactory
*   javax.xml.transform.TransformerFactory
*   javax.xml.validation.SchemaFactory
*   javax.xml.xpath.XPathFactory
-->

<h4 id="org-yaml-snakeyaml">org.yaml.snakeyaml</h4>
<p>Protection against code injection</p>
<ul>
<li>org.yaml.snakeyaml.Yaml</li>
</ul>
<h4 id="java-sql">java.sql</h4>
<p>Protection against sql injection</p>
<ul>
<li>java.sql.Statement</li>
<li>java.sql.Connection</li>
</ul>
<h4 id="java-xml">java.xml</h4>
<p>Protection against XML External Entities/Entity Expansion</p>
<ul>
<li>javax.xml.parsers.DocumentBuilderFactory</li>
<li>javax.xml.parsers.SAXParserFactory</li>
<li>javax.xml.transform.TransformerFactory</li>
<li>javax.xml.validation.SchemaFactory</li>
<li>javax.xml.xpath.XPathFactory</li>
</ul>


<details><summary><strong>Basic Protection Set Recipes List</strong>
| See <a href="https://github.com/SecureCodeWarrior/cookbook-basic-protection-set">Basic Protection Set Recipes</a> at GitHub
</summary>

<h4>Details</h4>
<dl>
<dt>Crypto: Cipher: Insecure Asymmetric Cryptographic Algorithm </dt>
<dd>This cryptographic algorithm is not recommended</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use strong symmetric cryptographic algorithm </dt>
<dd>Could lead to cryptographic weakness</dd>

<dt>Crypto: KeyAgreement: Insecure Cryptographic Algorithm </dt>
<dd>This cryptographic algorithm is insecure</dd>

<dt>Crypto: KeyAgreement: Guide on Approved Cryptographic Algorithm</dt>
<dd>This cryptographic algorithm is not recommended</dd>

<dt>Crypto: KeyPair Generation: Insecure Cryptographic Algorithm </dt>
<dd>This cryptographic algorithm is insecure</dd>

<dt>Crypto: KeyPair Generation: Non Standard Cryptographic Algorithm </dt>
<dd>This cryptographic algorithm is not recommended</dd>

<dt>Crypto: KeyPair Generation: Approved Standard Cryptographic Algorithm </dt>
<dd>This cryptographic algorithm is not recommended</dd>

<dt>Crypto: Signature: Insecure Hashing Algorithm </dt>
<dd>This hashing algorithm is not recommended for cryptographic use</dd>

<dt>Crypto: Signature: Non Standard Hashing Algorithm </dt>
<dd>This hashing algorithm is not recommended for cryptographic use</dd>

<dt>Crypto: Signature: Approved Hashing Algorithm</dt>
<dd>This hashing algorithm is not recommended for cryptographic use</dd>

<dt>Data Protection - Cryptography: Avoid brute forcing: Use sufficiently long key sizes: keyGenerator </dt>
<dd>Could lead to brute forcing or other cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use sufficiently long key sizes: keyGenerator bad value</dt>
<dd>Could lead to brute forcing or other cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate key pair generation algorithm: insecure </dt>
<dd>Could lead to cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate key pair generation algorithm: not recommended </dt>
<dd>Could lead to cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: DES family </dt>
<dd>Could lead to cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: Hmac family </dt>
<dd>Could lead to cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: Hmac family 1</dt>
<dd>Could lead to cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: Other algorithms </dt>
<dd>Could lead to cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: insecure SecretKeyFactory </dt>
<dd>Could lead to cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: not recommended SecretKeyFactory </dt>
<dd>This cryptographic algorithm is not recommended</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use appropriate secret key generation algorithm: other SecretKeyFactory </dt>
<dd>Could lead to cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use sufficiently long key sizes: keyPairGenerator </dt>
<dd>Could lead to brute forcing or other cryptographic weakness</dd>

<dt>Data Protection - Cryptography: Avoid cryptographic weakness: Use sufficiently long key sizes: keyPairGenerator bad value </dt>
<dd>Could lead to brute forcing or other cryptographic weakness</dd>

<dt>Data Protection - Secure Data Storage: Avoid data exposure: Use Cipher instead of NullCipher </dt>
<dd>Could lead to data exposure</dd>

<dt>Data: Injection: Parameterize LDAP Filters: DirContext#search</dt>
<dd>Could lead to LDAP Injection</dd>

<dt>Portability Flaw: Avoid locale dependent comparisons: equals after case conversion</dt>
<dd>Could behave differently based on the systems locale</dd>

<dt>TLS: Weak Encryption: Insecure Version </dt>
<dd>Could lead to Data Exposure</dd>

<dt>TLS: Weak Encryption: Outdated Version</dt>
<dd>Could lead to Data Exposure</dd>

<dt>Injection: Avoid XML Injection: Use setSchema </dt>
<dd>Could lead to XML Injection</dd>

<dt>Injection: Avoid XML Injection: Use setFeature </dt>
<dd>Could lead to XML Injection</dd>

<dt>Injection: Avoid XML Injection: setFeature with bad value</dt>
<dd>Could lead to XML Injection</dd>

<dt>Input Validation: Avoid XXE: Do not set DocumentBuilderFactory external-parameter-entities to true </dt>
<dd>Could lead to XXE</dd>

<dt>Input Validation: Avoid XXE: Do not set DocumentBuilderFactory load-external-dtd to true </dt>
<dd>Could lead to XXE</dd>

<dt>Input Validation: Avoid XXE: Do not set DocumentBuilderFactory setXIncludeAware to true </dt>
<dd>Could lead to XXE</dd>

<dt>Input Validation: Avoid XXE: Do not set DocumentBuilderFactory setExpandEntityReferences to true </dt>
<dd>Could lead to XXE</dd>

<dt>InputValidation: Avoid XXE: Do not set XMLInputFactory Property to true </dt>
<dd>Could lead to XXE</dd>

<dt>XML External Entities: DocumentBuilderFactory setExpandEntityReferences: to false </dt>
<dd>Could lead to XXE</dd>

<dt>XML External Entities: DocumentBuilderFactory setFeature: dissallow-doctype-decl </dt>
<dd>Could lead to XXE</dd>

<dt>XML External Entities: DocumentBuilderFactory setFeature: external-parameter-entities should be set first </dt>
<dd>Could lead to XXE</dd>

<dt>XML External Entities: DocumentBuilderFactory setFeature: load-external-dtd </dt>
<dd>Could lead to XXE</dd>

<dt>XML External Entities: DocumentBuilderFactory setXIncludeAware </dt>
<dd>Could lead to XXE</dd>

<dt>XML External Entities: DocumentBuilderFactory setFeature: dissallow-doctype-decl wrong boolean </dt>
<dd>Could lead to XXE</dd>

<dt>XML External Entities: XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES</dt>
<dd>Could lead to XXE</dd>

<dt>XML External Entities: XMLInputFactory.SUPPORT_DTD</dt>
<dd>Could lead to XXE</dd>

<dt>Injection: Avoid SQL Injection: Use Parameterized Queries (PreparedStatement)</dt>
<dd>Could lead to SQL Injection</dd>

<dt>Injection: Avoid SQL Injection: Use Parameterized Queries (Statement)</dt>
<dd>Could lead to SQL Injection</dd>

<dt>Injection: Avoid Code Injection: Use SafeConstructor: no arguments</dt>
<dd>Could lead to Remote Code Execution</dd>

<dt>Injection: Avoid Code Injection: Use SafeConstructor: 1st argument of type Constructor</dt>
<dd>Could lead to Remote Code Execution</dd>

<dt>Injection: Avoid Code Injection: Use SafeConstructor: arguments, but no Constructor argument</dt>
<dd>Could lead to Remote Code Execution</dd>

</dl>

</details>
</details>
<details>
<summary><strong>Java Gotchas</strong> - 1 recipe(s) -

<p>Examples of simple Java mistakes that can be easily detected and fixed with Sensei</p>
</summary>

<h4>Overview</h4>
<ul>
<li>split "." does not split a string delimited by 'full stop' characters</li>
</ul>
</details>
<details>
<summary><strong>Secure Code Warrior Blog Examples</strong> - external recipe(s) -

<p>Recipes used to support the Secure Code Warrior Blog examples which provide Use-Case examples of Sensei. e.g. POJO, JUnit 5, Basic SQL Injection fixing, etc</p>
</summary>

<ul>
<li>19 recipes</li>
<li>See <a href="https://github.com/SecureCodeWarrior/sensei-blog-examples">Sensei Blog Examples Recipes</a> at GitHub</li>
</ul>

<!--
*   POJO
    *   Converting System.out.println to using a Logger
    *   Adding a Private Constructor to a Utility Class
    *   Basic Immutability
*   JUnit 5
    *   Adding and Removing Annotations
    *   Adding Parameters to Annotations
    *   Creating Library Documentation Links to Tutorials and Examples
    *   Amending Visibility Modifiers of Methods and Classes
*   Guice
    *   Detecting Forgotten Guice Dependency Injection Wiring
*   SQL Injection Fixes
    *   Fix SQL Injection Vulnerability
-->
<h4>Overview</h4>
<ul>
<li>POJO<ul>
<li>Converting System.out.println to using a Logger</li>
<li>Adding a Private Constructor to a Utility Class</li>
<li>Basic Immutability</li>
</ul>
</li>
<li>JUnit 5<ul>
<li>Adding and Removing Annotations</li>
<li>Adding Parameters to Annotations</li>
<li>Creating Library Documentation Links to Tutorials and Examples</li>
<li>Amending Visibility Modifiers of Methods and Classes</li>
</ul>
</li>
<li>Guice<ul>
<li>Detecting Forgotten Guice Dependency Injection Wiring</li>
</ul>
</li>
<li>SQL Injection Fixes<ul>
<li>Fix SQL Injection Vulnerability</li>
</ul>
</li>
</ul>



<details><summary>More Details</summary>
<dl>
<dt>JUnit: Make @Disabled @Test from SKIPTHIS</dt>
<dd>Stop naming methods SKIPTHIS, use @Disabled @Test instead</dd>

<dt>JUnit: in SkipThisTest remove @Disabled and revert to SKIPTHIS</dt>
<dd>remove @Disabled and revert to SKIPTHIS for demo purposes in the project</dd>

<dt>Logger: use logger instead of println</dt>
<dd>use logger instead of println - remember stop using System.out.println</dd>

<dt>Logger: add logger</dt>
<dd>Add logger to class</dd>

<dt>remember to add disabled description</dt>
<dd>@Disabled should really have a description explaining why</dd>

<dt>Junit docs link</dt>
<dd>Learn about JUnit @Test method</dd>

<dt>learn about parameterized tests</dt>
<dd>learn about parameterized tests</dd>

<dt>Static Classes: create private constructor</dt>
<dd>create a private constructor for static classes</dd>

<dt>Test Classes in JUnit 5 do not need to be public</dt>
<dd>Test Classes in JUnit 5 do not need to be public</dd>

<dt>JUnit: JUnit 5 test methods do not need to be public</dt>
<dd>JUnit 5 test methods do not need public visibility</dd>

<dt>Guice Injected Field Not Public</dt>
<dd>If the Injected field is not public then the code might not be wired up.</dd>

<dt>sql injection - use a parameterized query</dt>
<dd>execute query with untrusted inputs is vulnerable to SQL Injection</dd>

<dt>Immutable: use final classes to prevent extension</dt>
<dd>Make the classes final to prevent people extending as mutable</dd>

<dt>JUnit: Junit 5 Test classes do not need to be public</dt>
<dd>Junit 5 Test classes do not need to be public</dd>

<dt>Immutable: Fields should be final and set in the constructor</dt>
<dd>Making fields final can highlight mutability issues</dd>

<dt>Immutable: default constructor should set field values from parameters</dt>
<dd>avoid default constructor and create a private constructor that sets the field values</dd>

<dt>Immutable: delete public void setters</dt>
<dd>void setters can be replaced with use of constructor or static factory methods</dd>

<dt>Immutable: avoid setters that return values</dt>
<dd>avoid setters methods that return values</dd>

<dt>Immutable: avoid void methods</dt>
<dd>void methods have side-effects, return a new object or primitve instead</dd>
</dl>
</details>
</details>
<details>
<summary><strong>Spring Boot Cookbook</strong> - 9 recipe(s) -

<p>A cookbook that simplifies Spring Boot development. It aims to automate common routines
performed by developers, preventing them to repeat themselves or introduce known issues</p>
</summary>

It covers the following modules:
<ul>
<li>Spring Beans</li>
<li>Spring MVC</li>
<li>Spring Data</li>
</ul>
</details>

## Extras
- [Sensei](https://www.securecodewarrior.com/sensei)
- [Sensei in action (video)](https://www.youtube.com/watch?v=mjXGliXJ7M8)
- [Sensei blog examples](https://github.com/SecureCodeWarrior/sensei-blog-examples)
- [Secure Code Warrior](https://www.securecodewarrior.com)
