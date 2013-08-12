package Tests.SchemaComparerTests;

/**
 * Created with IntelliJ IDEA.
 * User: Akash Kc
 * Date: 8/8/13
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
import org.junit.*;
import Entity.*;
import java.util.*;
import Utility.*;

public class SchemaComparerTests {

    @Test
    public void CompareSchemaColumnsShouldReturnsColumnsWhichDoesNotExistInTarget()
    {
        Column col1 = new Column();
        col1.setName("col1");

        Column col2 = new Column();
        col2.setName("col2");

        Column col3 = new Column();
        col2.setName("col3");

        List<Column> sourceColumns = new ArrayList<Column>();
        List<Column> targetColumns = new ArrayList<Column>();

        sourceColumns.add(col1);
        sourceColumns.add(col2);
        sourceColumns.add(col3);

        targetColumns.add(col1);

        List<Column> expectedFilteredColumns = new ArrayList<Column>();
        expectedFilteredColumns.add(col2);
        expectedFilteredColumns.add(col3);

        List<Column> actualFilteredColumns = SchemaComparer.CompareSchemaColumns(sourceColumns,targetColumns);

        Assert.assertEquals(expectedFilteredColumns,actualFilteredColumns);

    }

    @Test
    public void CompareSchemaTriggersShouldReturnsTriggerWhichDoesNotExistInTarget()
    {
        Trigger trigger1 = new Trigger();
        trigger1.setName("trigger1");

        Trigger trigger2 = new Trigger();
        trigger2.setName("trigger2");

        Trigger trigger3 = new Trigger();
        trigger3.setName("trigger3");

        List<Trigger> sourceTriggers = new ArrayList<Trigger>();
        List<Trigger> targetTriggers = new ArrayList<Trigger>();

        sourceTriggers.add(trigger1);
        sourceTriggers.add(trigger2);
        sourceTriggers.add(trigger3);

        targetTriggers.add(trigger1);

        List<Trigger> expectedFilteredTriggers = new ArrayList<Trigger>();
        expectedFilteredTriggers.add(trigger2);
        expectedFilteredTriggers.add(trigger3);

        List<Trigger> actualFilteredTriggers = SchemaComparer.CompareSchemaTriggers(sourceTriggers,targetTriggers);

        Assert.assertEquals(expectedFilteredTriggers,actualFilteredTriggers);

    }

    @Test
    public void CompareSchemaStoredProcedureShouldReturnsStoredProceduresWhichDoesNotExistInTarget()
    {
        StoredProcedure sp1 = new StoredProcedure();
        sp1.setName("sp1");

        StoredProcedure sp2 = new StoredProcedure();
        sp2.setName("sp2");

        StoredProcedure sp3 = new StoredProcedure();
        sp3.setName("sp3");

        List<StoredProcedure> sourceStoredProcedures = new ArrayList<StoredProcedure>();
        List<StoredProcedure> targetStoredProcedures = new ArrayList<StoredProcedure>();

        sourceStoredProcedures.add(sp1);
        sourceStoredProcedures.add(sp2);
        sourceStoredProcedures.add(sp3);

        targetStoredProcedures.add(sp1);

        List<StoredProcedure> expectedFilteredStoredProcedure = new ArrayList<StoredProcedure>();
        expectedFilteredStoredProcedure.add(sp2);
        expectedFilteredStoredProcedure.add(sp3);

        List<StoredProcedure> actualFilteredStoredProcedures = SchemaComparer.CompareSchemaStoredProcedures(sourceStoredProcedures,targetStoredProcedures);

        Assert.assertEquals(expectedFilteredStoredProcedure,actualFilteredStoredProcedures);

    }

    @Test
    public void CompareSchemaViewsShouldReturnsViewsWhichDoesNotExistInTarget()
    {
        View view1 = new View();
        view1.setName("view1");

        View view2 = new View();
        view2.setName("view2");

        View view3 = new View();
        view3.setName("view3");

        List<View> sourceViews = new ArrayList<View>();
        List<View> targetViews = new ArrayList<View>();

        sourceViews.add(view1);
        sourceViews.add(view2);
        sourceViews.add(view3);

        targetViews.add(view1);

        List<View> expectedFilteredViews = new ArrayList<View>();
        expectedFilteredViews.add(view2);
        expectedFilteredViews.add(view3);

        List<View> actualFilteredViews = SchemaComparer.CompareSchemaViews(sourceViews,targetViews);

        Assert.assertEquals(expectedFilteredViews,actualFilteredViews);
    }


    @Test
    public void CompareSchemaIndexesShouldReturnsIndexesWhichDoesNotExistInTarget()
    {
        Index index1 = new Index();
        index1.setName("index1");

        Index index2 = new Index();
        index2.setName("index2");

        Index index3 = new Index();
        index3.setName("index3");

        List<Index> sourceIndexes = new ArrayList<Index>();
        List<Index> targetIndexes = new ArrayList<Index>();

        sourceIndexes.add(index1);
        sourceIndexes.add(index2);
        sourceIndexes.add(index3);

        targetIndexes.add(index1);

        List<Index> expectedFilteredIndexes = new ArrayList<Index>();
        expectedFilteredIndexes.add(index1);
        expectedFilteredIndexes.add(index3);

        List<Index> actualFilteredIndexes = SchemaComparer.CompareSchemaIndexes(sourceIndexes,targetIndexes);

        Assert.assertEquals(expectedFilteredIndexes,actualFilteredIndexes);
    }
}
