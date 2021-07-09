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
<li>Spring Security CSRF protection: do not disable default protection</li>
<li>Security Misconfiguration: Content sniffing protection</li>
<li>Session Configuration: Invalidate the HttpSession after logout</li>
<li>Secure Transport: use RequiresSecure to enforce HTTPS</li>
<li>Secure Transport: use RequiresSecure to enforce HTTPS on all paths</li>
<li>Security Misconfiguration: Prevent session from being included in the URL</li>
<li>Security Misconfiguration: StrictHttpFirewall: Avoid DefaultHttpFirewall (method return type)</li>
<li>Security Misconfiguration: StrictHttpFirewall: Avoid DefaultHttpFirewall (instance creation)</li>
<li>Security Misconfiguration: StrictHttpFirewall: Rule configuration: HTTP method validation</li>
<li>Security Misconfiguration: StrictHttpFirewall: Rule configuration: Reject (URL encoded) backslash</li>
<li>Security Misconfiguration: StrictHttpFirewall: Rule configuration: Reject (URL encoded) null</li>
<li>Security Misconfiguration: StrictHttpFirewall: Rule configuration: Reject URL encoded double slash</li>
<li>Security Misconfiguration: StrictHttpFirewall: Rule configuration: Reject URL encoded percent</li>
<li>Security Misconfiguration: StrictHttpFirewall: Rule configuration: Reject URL encoded period</li>
<li>Security Misconfiguration: StrictHttpFirewall: Rule configuration: Reject URL encoded slash</li>
<li>Security Misconfiguration: StrictHttpFirewall: Rule configuration: Reject semicolon</li>
<li>Security Misconfiguration: CORS: disable</li>
<li>Authentication: Username Enumeration: avoid UsernameNotFoundException</li>
<li>Authentication: Username Enumeration: setHideUserNotFoundExceptions should be set to true</li>
</ul>
