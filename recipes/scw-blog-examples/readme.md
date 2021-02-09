## Secure Code Warrior Blog Examples
Recipes used to support the Secure Code Warrior Blog examples which provide Use-Case examples of Sensei. e.g. POJO, JUnit 5, Basic SQL Injection fixing, etc. Install: <a href='https://github.com/SecureCodeWarrior/sensei-blog-examples.git|master|.sensei'>use .git</a> (<a href='https://github.com/SecureCodeWarrior/public-cookbooks/wiki/How-to-add-a-cookbook#from-a-github-repo-directly'>How?</a>)

<ul>
<li>19 recipes</li>
<li>See <a href="https://github.com/SecureCodeWarrior/sensei-blog-examples">Sensei Blog Examples Recipes</a> at GitHub</li>
</ul>

<!--
#### Overview

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