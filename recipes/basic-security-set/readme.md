## Basic security set
Cookbook which can be used as a starting point for security.

<ul>
<li>49 recipes</li>
<li><a href="https://sensei-cookbook-registry.nonprod.securecodewarrior.com/securecodewarrior/security/basic-protection-set.zip">download .zip</a></li>
<li><a href="https://github.com/SecureCodeWarrior/cookbook-basic-protection-set.git">use .git</a></li>
</ul>

<p>
<em>This cookbook contains a set of low effort recipes that can be used to detect, fix and prevent common recurring critical and high severity vulnerabilities. Enabling this cookbook will set a security baseline. The expected outcome from this cookbook is not to fix issues that are currently present in the codebase. Because we expect that these flaws have been detected by existing security measures such as peer reviews, penetration tests, and SAST tools. The main purpose is that we prevent new instances of these issues from being introduced in the codebase. Because catching these typical flaws late during development or even in production would increase the cost and time of fixing the issues significantly. Overall, this cookbook gives you the opportunity to improve the state of security by preventing the reappearance from common flaws.<em>
</p>

<!--
#### org.yaml.snakeyaml

Protection against code injection

*   org.yaml.snakeyaml.Yaml

#### java.sql

Protection against sql injection

*   java.sql.Statement
*   java.sql.Connection

#### java.xml

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
