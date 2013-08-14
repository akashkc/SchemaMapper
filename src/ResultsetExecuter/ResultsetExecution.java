package ResultsetExecuter;

/**
 * User: Akash
 * Deals with various operation on ResultSet
 */
import java.util.*;
import java.sql.*;
import Query.*;
import Entity.*;
import Constants.*;
import SchemaKeywords.*;
public class ResultsetExecution {

    /**
     * Get all items of the Resultset of given itemColumn
     * @param resultSet
     * @param itemColumn
     * @return
     * @throws SQLException
     */
    public static List<String> getResultsetItems(ResultSet resultSet, String itemColumn) throws SQLException
    {
        List<String> listItem = new ArrayList<String>();
        resultSet.beforeFirst();
        while(resultSet.next())
        {
            if (!resultSet.wasNull())
            {
                listItem.add(resultSet.getString(itemColumn));
            }
        }
        return listItem;
    }

    /**
     * Get the items of given column of specified table in given ResultSet
     * @param resultSet
     * @param tableColumn
     * @param tableName
     * @param itemColumn
     * @return listItem
     * @throws SQLException
     */
    public static List<String> getResultsetItems(ResultSet resultSet,String tableColumn,String tableName, String itemColumn) throws SQLException
    {
        List<String> listItem = new ArrayList<String>();
        resultSet.beforeFirst();
        while (resultSet.next())
        {
            if (!resultSet.wasNull())
            {
                if(resultSet.getString(tableColumn).equalsIgnoreCase(tableName))
                {
                    try
                    {
                        listItem.add(resultSet.getString(itemColumn));
                    }
                    catch (Exception ex)
                    {
                        System.out.print(ex.toString());
                    }

                }
            }
        }
        return listItem;
    }



    /**
     * Get the hashmap of database key with their associated list of item.
     * @param resultSetMap
     * @param requestType
     * @return hashMap of key and their associated items
     * @throws SQLException
     */
    public static Database getDatabaseBaseEntityBasedOnResultset(Map<String, ResultSet> resultSetMap, SchemaRequestType requestType) throws SQLException
    {
        Database database = new Database();
        Map<String, List<String>> databaseItems = new HashMap<String, List<String>>();
        List<String> listTableNames = new ArrayList<String>();

        // Check whether requested type requested for the collection of tables
        if(requestType.getIsTable())
        {
            ResultSet resultSet = resultSetMap.get(HashMapKey.Table);
            listTableNames = getResultsetItems(resultSet , MySql.TABLE_NAME);
            List<Table> listTables = new ArrayList<Table>();
            for(String tableName : listTableNames)
            {
                Table table = new Table();
                table.setName(tableName);
                listTables.add(table);
            }
            database.setTable(listTables);
        }

        List<Table> listTables = database.getTable();
        List<Table> listTableEntity = new ArrayList<Table>();
        if (!listTables.isEmpty())
        {
            for(Table table : listTables)
            {
                Table objTable = new Table();
                objTable.setName(table.getName());

                if(requestType.getIsColumn())
                {
                    if (resultSetMap.containsKey(HashMapKey.Column))
                    {
                        // Getting the list of column names
                        ResultSet columnResultSet = resultSetMap.get(HashMapKey.Column);
                        List<String> listColumns = getResultsetItems(columnResultSet, MySql.TABLE_NAME ,table.getName(),MySql.COLUMN_NAME );
                        if (!listColumns.isEmpty())
                        {
                            List<Column> listColumnEntity = new ArrayList<Column>();
                            // Setting column name in the column entity
                            for (String columnName : listColumns)
                            {
                                Column column = new Column();
                                column.setName(columnName);
                                listColumnEntity.add(column);
                            }
                            objTable.setColumn(listColumnEntity);
                        }
                    }
                }
                // Checking whether request is from index or not
                if(requestType.getIsIndex())
                {
                    if (resultSetMap.containsKey(HashMapKey.Index))
                    {
                        ResultSet indexResultSet = resultSetMap.get(HashMapKey.Index);
                        List<String> listIndex = getResultsetItems(indexResultSet, MySql.TABLE_NAME ,table.getName(),MySql.CONSTRAINT_NAME );
                        if (!listIndex.isEmpty())
                        {
                            List<Index> listIndexEntity = new ArrayList<Index>();
                            // Setting column name in the column entity
                            for (String indexName : listIndex)
                            {
                                Index index = new Index();
                                index.setName(indexName);
                                listIndexEntity.add(index);
                            }
                            objTable.setIndexes(listIndexEntity);
                        }
                    }
                }

                // Checking whether request is for triggers or not
                if(requestType.getIsTrigger())
                {
                    if (resultSetMap.containsKey(HashMapKey.Trigger))
                    {
                        ResultSet triggerResultSet = resultSetMap.get(HashMapKey.Trigger);
                        List<String> listTrigger = getResultsetItems(triggerResultSet, MySql.TriggersColumns.EVENT_OBJECT_TABLE ,table.getName(),MySql.TriggersColumns.TRIGGER_NAME );
                        if (!listTrigger.isEmpty())
                        {
                            List<Trigger> listTriggerEntity = new ArrayList<Trigger>();
                            // Setting column name in the column entity
                            for (String triggerName : listTrigger)
                            {
                                Trigger trigger = new Trigger();
                                trigger.setName(triggerName);
                                listTriggerEntity.add(trigger);
                            }
                            objTable.setTriggers(listTriggerEntity);
                        }
                    }
                }

                // Check whether request type requested for constraint
                if(requestType.getIsConstraint())
                {
                    if (resultSetMap.containsKey(HashMapKey.Constraint))
                    {
                        ResultSet resultSet = resultSetMap.get(HashMapKey.Constraint);
                    }
                }

                // Check whether requested type requested for list of function
                if (requestType.getIsFunction())
                {
                    if (resultSetMap.containsKey(HashMapKey.Function))
                    {
                        ResultSet resultSet = resultSetMap.get(HashMapKey.Function);
                    }
                }
                listTableEntity.add(objTable);
            }
            database.setTable(listTableEntity);
        }
        // Checking whether request is for Views or not
        if (requestType.getIsView())
        {
            if (resultSetMap.containsKey(HashMapKey.View))
            {
                ResultSet viewResultSet = resultSetMap.get(HashMapKey.View);
                List<String> listView = getResultsetItems(viewResultSet, MySql.TABLE_NAME);
                if (!listView.isEmpty())
                {
                    List<View> listViewEntity = new ArrayList<View>();
                    // Setting view name in the View entity
                    for (String viewName : listView)
                    {
                        View view = new View();
                        view.setName(viewName);
                        listViewEntity.add(view);
                    }
                   database.setView(listViewEntity);
                }
            }
        }

        if(requestType.getIsStoredProcedure())
        {
            if (resultSetMap.containsKey(HashMapKey.StoredProcedure))
            {
                ResultSet storedProcedureResultSet = resultSetMap.get(HashMapKey.StoredProcedure);
                List<String> listStoredProcedure = getResultsetItems(storedProcedureResultSet, MySql.RoutinesColumn.ROUTINE_NAME);
                if (!listStoredProcedure.isEmpty())
                {
                    List<StoredProcedure> listStoredProcedureEntity = new ArrayList<StoredProcedure>();
                    // Setting view name in the View entity
                    for (String storedProcedureName : listStoredProcedure)
                    {
                        StoredProcedure storedProcedure = new StoredProcedure();
                        storedProcedure.setName(storedProcedureName);
                        listStoredProcedureEntity.add(storedProcedure);
                    }
                    database.setStoredProcedure(listStoredProcedureEntity);
                }
            }

        }
        return database;
    }
}
