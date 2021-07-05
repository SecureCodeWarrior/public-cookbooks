# NUM00-J
Not clear in which cases to check for overflow/underflow. Check result value range is within expectations.
- Mark numerical operators to use a safe wrapper function that checks results. Or use Math.addExact
- AtomicInteger has the same issues

NUM00-J-EX0: Depending on circumstances, integer overflow could be benign (e.g. modular arithmetic)
NUM00-J-EX1: Prevention of integer overflow is unnecessary for numeric fields that undergo bitwise operations and not arithmetic operations

# NUM01-J
- Mark mixed use of bitwise and arithmetic operations 

NUM01-EX0: Bitwise operations may be used to construct constant expressions.
NUM01-J-EX1: Data that is normally treated arithmetically may be treated with bitwise operations for the purpose of serialization or deserialization. This alternative treatment is often required for handling data from a file or network socket. Bitwise operations are also permitted when handling data from a tightly packed data structure of bytes.

# NUM02-J [Marked by IntelliJ]

# NUM03-J
- Mark read from inputStream to integer to mask the input to ensure unsigned correctness.

# NUM04-J [Deprecated]
# NUM05-J [Deprecated]
# NUM06-J [Deprecated]

# NUM07-J
- IntelliJ detects comparison with NaN as always false, but does not explain what is wrong.

# NUM08-J
- Mark untrusted float values from string to handle exceptional values, unless wanted behavior

# NUM09-J
- Mark non-integers as loop indices

# NUM10-J
- Mark BigDecimal constructor with float/double literal

# NUM11-J
- Look for Double.toString followed by String.equals(String) (possible manipulations in between), replace with BigDecimal compare.

# NUM12-J
- Mark conversions where loss can occur (narrowing conversions)

# NUM13-J
- Mark conversions from int to long (literal auto-cast on arguments etc)

# NUM14-J
- Mark shift operations when bounds not checked?
  => How to determine this?