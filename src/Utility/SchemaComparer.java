package Utility;
import Entity.*;
import java.util.*;


public class SchemaComparer {

    /**
     * Compares source and target database and returns the resulted database
     * @param sourceDatabase
     * @param targetDatabase
     * @return
     */
    public static Database CompareDatabase(Database sourceDatabase, Database targetDatabase)
    {
        Database filteredDatabase = new Database();


        // Tables
        List<Table> sourceTables = sourceDatabase.getTable();
        List<Table> targetTables = targetDatabase.getTable();

        // Stored Procedure
        List<StoredProcedure> sourceStoredProcedures = sourceDatabase.getStoredProcedure();
        List<StoredProcedure> targetStoredProcedures = targetDatabase.getStoredProcedure();

        // Views
        List<View> sourceViews = sourceDatabase.getView();
        List<View> targetViews = targetDatabase.getView();

        List<Table> filteredTables = CompareSchemaTables(sourceTables,targetTables);
        List<StoredProcedure> filteredStoredProcedures = CompareSchemaStoredProcedures(sourceStoredProcedures,targetStoredProcedures);

        List<View> filteredViews = CompareSchemaViews(sourceViews,targetViews);

        filteredDatabase.setName(sourceDatabase.getName());
        filteredDatabase.setTable(filteredTables);
        filteredDatabase.setStoredProcedure(filteredStoredProcedures);
        filteredDatabase.setView(filteredViews);

        return filteredDatabase;
    }

    public static List<Table> CompareSchemaTables(List<Table> sourceTables, List<Table> targetTables)
    {
        List<Table> filteredTables = new ArrayList<Table>();

        for (Table sourceTable : sourceTables)
        {
            Boolean isTableExistInTarget = false;
            for (Table targetTable : targetTables)
            {
                   if (sourceTable.getName().equals(targetTable.getName()))
                   {
                       Table filteredTable = new Table();
                       filteredTable.setName(sourceTable.getName());

                       isTableExistInTarget = true;
                       // Columns
                       List<Column> sourceColumns = sourceTable.getColumn();
                       List<Column> targetColumns = targetTable.getColumn();

                       // Indexes
                       List<Index> sourceIndexes = sourceTable.getIndexes();
                       List<Index> targetIndexes = targetTable.getIndexes();

                       // Triggers
                       List<Trigger> sourceTriggers = sourceTable.getTrigger();
                       List<Trigger> targetTriggers = targetTable.getTrigger();

                       // Constraints
                       List<Constraint> sourceConstraints = sourceTable.getConstraint();
                       List<Constraint> targetConstraints = targetTable.getConstraint();

                       // Keys
                       List<Key> sourceKeys = sourceTable.getKeys();
                       List<Key> targetKeys = targetTable.getKeys();


                       List<Column> filteredColumns = CompareSchemaColumns(sourceColumns,targetColumns);
                       List<Trigger> filteredTriggers = CompareSchemaTriggers(sourceTriggers, targetTriggers);
                      // List<Index> filteredIndexes = CompareSchemaIndexes(sourceIndexes, targetIndexes);
                      // List<Column> filteredColumns = CompareSchemaColumns(sourceColumns,targetColumns);
                      // List<Column> filteredColumns = CompareSchemaColumns(sourceColumns,targetColumns);

                       filteredTable.setColumn(filteredColumns);
                      // filteredTable.setIndexes(filteredIndexes);
                       filteredTable.setTriggers(filteredTriggers);

                       filteredTables.add(filteredTable);
                   }
                if(!isTableExistInTarget)
                {
                    filteredTables.add(sourceTable);
                }
            }

        }
        return filteredTables;
    }


    /**
     * Compare columns of two database and filter columns which
     * does not exist in target database.
     * @param sourceColumns
     * @param targetColumns
     * @return list of columns which does not exist in target database.
     */
    public static List<Column> CompareSchemaColumns(List<Column> sourceColumns, List<Column> targetColumns)
    {
        List<Column> filteredColumns = new ArrayList<Column>();
        for (Column sourceColumn : sourceColumns)
        {
            Boolean isSourceColumnExistInTarget = false;
            for (Column targetColumn : targetColumns)
            {
                if(sourceColumn.getName().equals(targetColumn.getName()))
                {
                    isSourceColumnExistInTarget = true;
                }
                if (isSourceColumnExistInTarget) break;
            }
            if(!isSourceColumnExistInTarget)
                filteredColumns.add(sourceColumn);
        }
        return filteredColumns;
    }

    /**
     * Compare triggers of two database and filter triggers which
     * does not exist in target database.
     * @param sourceTriggers
     * @param targetTriggers
     * @return
     */
    public static List<Trigger> CompareSchemaTriggers(List<Trigger> sourceTriggers, List<Trigger> targetTriggers)
    {
        List<Trigger> filteredTriggers = new ArrayList<Trigger>();
        for (Trigger sourceTrigger : sourceTriggers)
        {
            Boolean isSourceTriggerExistInTarget = false;
            for (Trigger targetTrigger : targetTriggers)
            {
                if(sourceTrigger.getName().equals(targetTrigger.getName()))
                {
                    isSourceTriggerExistInTarget = true;
                    break;
                }
            }
            if(!isSourceTriggerExistInTarget)
                filteredTriggers.add(sourceTrigger);
        }
        return filteredTriggers;
    }

    /**
     * Compare stored procedures of two database and filter stored procedures which
     * does not exist in target database.
     * @param sourceStoredProcedures
     * @param targetStoredProcedures
     * @return
     */
    public static List<StoredProcedure> CompareSchemaStoredProcedures(List<StoredProcedure> sourceStoredProcedures, List<StoredProcedure> targetStoredProcedures)
    {
        List<StoredProcedure> filteredStoredProcedures = new ArrayList<StoredProcedure>();
        for (StoredProcedure sourceStoredProcedure : sourceStoredProcedures)
        {
            Boolean isSourceStoredProcedureExistInTarget = false;
            for (StoredProcedure targetStoredProcedure : targetStoredProcedures)
            {
                if(sourceStoredProcedure.getName().equals(targetStoredProcedure.getName()))
                {
                    isSourceStoredProcedureExistInTarget = true;
                    break;
                }
            }
            if(!isSourceStoredProcedureExistInTarget)
                filteredStoredProcedures.add(sourceStoredProcedure);
        }
        return filteredStoredProcedures;
    }


    /**
     * Compare views of two database and filter views which
     * does not exist in target database.
     * @param sourceViews
     * @param targetViews
     * @return
     */
    public static List<View> CompareSchemaViews(List<View> sourceViews, List<View> targetViews)
    {
        List<View> filteredViews = new ArrayList<View>();
        for (View sourceView : sourceViews)
        {
            Boolean isSourceViewExistInTarget = false;
            for (View targetView : targetViews)
            {
                if(sourceView.getName().equals(targetView.getName()))
                {
                    isSourceViewExistInTarget = true;
                    break;
                }
            }
            if(!isSourceViewExistInTarget)
                filteredViews.add(sourceView);
        }
        return filteredViews;
    }

    /**
     * Compare indexes of two database and filter indexes which
     * does not exist in target database.
     * @param sourceIndexes
     * @param targetIndexes
     * @return
     */
    public static List<Index> CompareSchemaIndexes(List<Index> sourceIndexes, List<Index> targetIndexes)
    {
        List<Index> filteredIndexes = new ArrayList<Index>();
        for (Index sourceIndex : sourceIndexes)
        {
            Boolean isSourceIndexExistInTarget = false;
            for (Index targetIndex : targetIndexes)
            {
                if(sourceIndex.getName().equals(targetIndex.getName()))
                {
                    isSourceIndexExistInTarget = true;
                    break;
                }
            }
            if(!isSourceIndexExistInTarget)
                filteredIndexes.add(sourceIndex);
        }
        return filteredIndexes;
    }
}
