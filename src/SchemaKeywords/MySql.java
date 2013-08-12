package SchemaKeywords;

/**
 * User: Akash
 */
public class MySql {

    // Database
    public static final String INFORMATION_SCHEMA = "INFORMATION_SCHEMA";

    // Tables Name
    public static final String CHARACTER_SETS = "CHARACTER_SETS";
    public static final String COLLATION_CHARACTER_SET_APPLICABILITY = "COLLATION_CHARACTER_SET_APPLICABILITY";
    public static final String COLLATIONS = "COLLATIONS";
    public static final String COLUMN_PRIVILEGES = "COLUMN_PRIVILEGES";
    public static final String COLUMNS = "COLUMNS";
    public static final String ENGINES = "ENGINES";
    public static final String EVENTS = "EVENTS";
    public static final String FILES = "FILES";
    public static final String GLOBAL_STATUS = "GLOBAL_STATUS";
    public static final String GLOBAL_VARIABLES = "GLOBAL_VARIABLES";
    public static final String INNODB_CMP = "INNODB_CMP";
    public static final String INNODB_CMP_RESET = "INNODB_CMP_RESET";
    public static final String INNODB_CMPMEM = "INNODB_CMPMEM";
    public static final String INNODB_CMPMEM_RESET = "INNODB_CMPMEM_RESET";
    public static final String INNODB_LOCK_WAITS = "INNODB_LOCK_WAITS";
    public static final String INNODB_LOCKS = "INNODB_LOCKS";
    public static final String INNODB_TRX = "INNODB_TRX";
    public static final String KEY_COLUMN_USAGE = "KEY_COLUMN_USAGE";
    public static final String PARAMETERS = "PARAMETERS";
    public static final String PARTITIONS = "PARTITIONS";
    public static final String PLUGINS = "PLUGINS";
    public static final String PROCESSLIST = "PROCESSLIST";
    public static final String PROFILING = "PROFILING";
    public static final String REFERENTIAL_CONSTRAINTS = "REFERENTIAL_CONSTRAINTS";
    public static final String ROUTINES = "ROUTINES";
    public static final String SCHEMA_PRIVILEGES = "SCHEMA_PRIVILEGES";
    public static final String SCHEMATA = "SCHEMATA";
    public static final String SESSION_STATUS = "SESSION_STATUS";
    public static final String SESSION_VARIABLES = "SESSION_VARIABLES";
    public static final String STATISTICS = "STATISTICS";
    public static final String TABLE_CONSTRAINTS = "TABLE_CONSTRAINTS";
    public static final String TABLE_PRIVILEGES = "TABLE_PRIVILEGES";
    public static final String TABLES = "TABLES";
    public static final String TABLESPACES = "TABLESPACES";
    public static final String TRIGGERS = "TRIGGERS";
    public static final String USER_PRIVILEGES = "USER_PRIVILEGES";
    public static final String VIEWS = "VIEWS";

    //
    public static final String TABLE_SCHEMA = "TABLE_SCHEMA";
    public static final String TABLE_NAME = "TABLE_NAME";
    public static final String TABLE_TYPE = "TABLE_TYPE";
    public static final String COLUMN_NAME = "COLUMN_NAME";
    public static final String COLUMN_KEY = "COLUMN_KEY";
    public static final String CONSTRAINT_NAME = "CONSTRAINT_NAME";


    /**
     * Routines Column
     */
    public class RoutinesColumn
    {
        public static final String ROUTINE_SCHEMA = "ROUTINE_SCHEMA";
        public static final String ROUTINE_NAME = "ROUTINE_NAME";
        public static final String ROUTINE_TYPE = "ROUTINE_TYPE";
    }

    /**
     * Triggers Tables Columns
     */
    public class TriggersColumns
    {
        public static final String TRIGGER_SCHEMA = "TRIGGER_SCHEMA";
        public static final String TRIGGER_NAME = "TRIGGER_NAME";
        public static final String EVENT_OBJECT_SCHEMA = "EVENT_OBJECT_SCHEMA";
        public static final String EVENT_OBJECT_TABLE = "EVENT_OBJECT_TABLE";
    }

    /**
     * RoutinesType Values
     */
    public class RoutinesTypeValue
    {
        public static final String PROCEDURE = "PROCEDURE";
    }

    /**
     * Table Type Possible Values
     */
    public class TableTypeValue
    {
        public static final String SYSTEM_VIEW = "SYSTEM VIEW";
        public static final String VIEW = "VIEW";
        public static final String BASE_TABLE = "BASE TABLE";

    }



}
