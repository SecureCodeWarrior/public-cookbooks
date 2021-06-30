# JdbcOperations with arg1 type string, anyArg type .*Setter
# QF: add untrusted to setter
<T> List<T> query(String sql, @Nullable PreparedStatementSetter pss, RowMapper<T> rowMapper)
<T> T query(String sql, @Nullable PreparedStatementSetter pss, ResultSetExtractor<T> rse)
void query(String sql, @Nullable PreparedStatementSetter pss, RowCallbackHandler rch) throws
<T> Stream<T> queryForStream(String sql, @Nullable PreparedStatementSetter pss, RowMapper<T> rowMapper)
int update(String sql, @Nullable PreparedStatementSetter pss)
int[] batchUpdate(String sql, BatchPreparedStatementSetter pss)
<T> int[][] batchUpdate(String sql, Collection<T> batchArgs, int batchSize, ParameterizedPreparedStatementSetter<T> pss)

# JdbcOperations with arg1 type string, arg2 type .*Callback
# QF: add untrusted to callback?
<T> T execute(String sql, PreparedStatementCallback<T> action)
<T> T execute(String callString, CallableStatementCallback<T> action)

# JdbcOperations with arg1 type string, arg2 type Object[], arg3 type int[]
# QF: add untrusted to arg2 and SQL type to arg3
<T> List<T> query(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper)
<T> T query(String sql, Object[] args, int[] argTypes, ResultSetExtractor<T> rse)
void query(String sql, Object[] args, int[] argTypes, RowCallbackHandler rch)
<T> T queryForObject(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper)
<T> T queryForObject(String sql, Object[] args, int[] argTypes, Class<T> requiredType)
Map<String, Object> queryForMap(String sql, Object[] args, int[] argTypes)
<T> List<T> queryForList(String sql, Object[] args, int[] argTypes, Class<T> elementType)
List<Map<String, Object>> queryForList(String sql, Object[] args, int[] argTypes)
SqlRowSet queryForRowSet(String sql, Object[] args, int[] argTypes)
int update(String sql, Object[] args, int[] argTypes)
int[] batchUpdate(String sql, List<Object[]> batchArgs, int[] argTypes)

# JdbcOperations with arg1 type string, optional second arg not type matching .*Callback, no arg type matching .*Setter
# QF: add untrusted as new arg at the end
<T> T query(String sql, ResultSetExtractor<T> rse)
<T> T query(String sql, ResultSetExtractor<T> rse, @Nullable Object... args)
<T> List<T> query(String sql, RowMapper<T> rowMapper)
<T> List<T> query(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
void query(String sql, RowCallbackHandler rch)
void query(String sql, RowCallbackHandler rch, @Nullable Object... args)
<T> Stream<T> queryForStream(String sql, RowMapper<T> rowMapper)
<T> Stream<T> queryForStream(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
<T> T queryForObject(String sql, RowMapper<T> rowMapper)
<T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
<T> T queryForObject(String sql, Class<T> requiredType)
<T> T queryForObject(String sql, Class<T> requiredType, @Nullable Object... args)
Map<String, Object> queryForMap(String sql)
Map<String, Object> queryForMap(String sql, @Nullable Object... args)
List<Map<String, Object>> queryForList(String sql)
List<Map<String, Object>> queryForList(String sql, @Nullable Object... args)
<T> List<T> queryForList(String sql, Class<T> elementType)
<T> List<T> queryForList(String sql, Class<T> elementType, @Nullable Object... args)
SqlRowSet queryForRowSet(String sql)
SqlRowSet queryForRowSet(String sql, @Nullable Object... args)
int update(String sql)
int update(String sql, @Nullable Object... args)
int[] batchUpdate(String... sql)
int[] batchUpdate(String sql, List<Object[]> batchArgs)