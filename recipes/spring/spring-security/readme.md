## Spring Security Cookbook
A cookbook that simplifies Spring Security development. It aims to automate common routines
performed by developers, preventing them to repeat themselves or introduce known issues.

It covers the following protections:
<ul>
<li>Protection against CSRF by setting HttpOnly flag to true</li>
<li>Include subdomains in the HSTS domain</li>
<li>Enforce HSTS protection against vulnerabilities over HTTP</li>
<li>Should use requiresSecure</li>
<li>Use .stronger() for a more secure alternative</li>
<li>Use .delux() for a 'stronger' password-based encryption</li>
<li>Protect against Session Fixation attacks</li>
<li>Encryptors requires the use of a random 8-byte salt</li>
<li>Avoid hardcoded secrets when using the Encryptors class</li>
<li>Spring Security recommends DelegatingPasswordEncoder for best practices </li>
<li>Spring Security recommends DelegatingPasswordEncoder for best practices (BCrypt)</li>
<li>Spring Security recommends DelegatingPasswordEncoder for best practices (Bean - BCrypt)</li>
<li>Spring Security recommends DelegatingPasswordEncoder for best practices (Bean)</li>
<li>Avoid hardcoded secrets when using passwordencoders</li>
<li>Security Misconfiguration: XSS protection: Disabled Header - block()</li>
<li>Security Misconfiguration: XSS protection: Disabled Header - disable()</li>
<li>Security Misconfiguration: XSS protection: Disabled Header - xssProtectionEnabled()</li>
<li>Security Misconfiguration: XSS protection: Add CSP header - XXssConfig</li>
<li>Security Misconfiguration: XSS protection: Add CSP header - xssProtection</li>
<li>Security Misconfiguration: Disabled Headers</li>
<li>Security Misconfiguration: Clickjacking protection: Disabled Header - frameOptions()</li>
</ul>
