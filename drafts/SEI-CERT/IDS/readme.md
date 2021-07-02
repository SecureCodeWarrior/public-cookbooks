https://wiki.sei.cmu.edu/confluence/display/java/2+Rules

# IDS00-J
- Mark use of PreparedStatement that does not use set*() before execute*()
- Mark strings containing untrusted data that are used as argument to  java.sql.Connection.prepareStatement or java.sql.Statement.executeQuery

# IDS01-J
- Mark untrusted input strings that are not argument of Normalizer.normalize before being used
- Mark direct use of untrusted input

# IDS02-J [Deprecated]

# IDS03-J
- Mark sensitive data used in logger calls 
  => How to define sensitive data?
  => Would have to be used in a sensitive way in the same file (specific API calls)
- Mark untrusted data as argument of logger calls
  => How does sensei make the distinction between untrusted and sanitized?
- Mark known insecure logger instances

# IDS04-J
- Limit size, limit number of files, validate location for unzip
  => Specific API calls that can be replaced/forced to take a validated path? File object?
- Use secure zip extraction libraries

# IDS05-J [Deprecated]

# IDS06-J
- PrintStream.format with fewer arguments than number of format markers +1? (what about references to the same argument?)
- mark untrusted input in format strings

# IDS07-J
- untrusted data as argument for runtime.exec
- any other eval/exec with untrusted data as input
- Mark any use of eval/exec
- Mark missing validation for arguments to eval/exec

# IDS08-J
- Mark untrusted data inserted into string that is used as regex, use Pattern.quote instead

# IDS09-J [Deprecated]
# IDS10-J [Deprecated]

# IDS11-J
- First validate untrusted data before further processing
- Mark any non-validation operation on untrusted data
- Normalize + replace non-character code points

# IDS12-J [Deprecated]
# IDS13-J [Deprecated]

# IDS14-J 
- Mark hidden form fields as untrusted data

# IDS15-J [No code changes]

# IDS16-J
- Input validation on PrintStream arguments

# IDS17-J
- XXE enable options
- Use safe parser
- SAXParser custom EntityResolver with validation
