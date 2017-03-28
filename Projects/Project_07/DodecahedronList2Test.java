import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;


public class DodecahedronList2Test {

    // Variables, objects and list
    private String listName = "List Test Name";
    private static int arrSizeTest = 0;
    private Dodecahedron[] dodObjList = new Dodecahedron[20];
    private Dodecahedron[] dodObjNullList = new Dodecahedron[20];

    @Before
    public void setUp() throws Exception {
        arrSizeTest = 0;
    }

    @Test
    public void getNameTest() throws Exception {
     DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
     Assert.assertEquals("", "List Test Name", dodTest2.getName());
    }

    @Test
    public void numberOfDodecahedronsTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        Assert.assertEquals("", 5, dodTest2.numberOfDodecahedrons());

        DodecahedronList2 dodNullTest2 = new DodecahedronList2(listName, dodObjNullList, 1);
        Assert.assertEquals("", 0, dodNullTest2.numberOfDodecahedrons());
    }

    @Test
    public void totalSurfaceAreaTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        double total = 0;
        for (int i = 0; i < arrSizeTest; i++) {
            total += dodObjList[i].surfaceArea();
        }
        Assert.assertEquals("", total, dodTest2.totalSurfaceArea(), .001);
    }

    @Test
    public void totalVolumeTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        double total = 0;
        for (int i = 0; i < arrSizeTest; i++) {
            total += dodObjList[i].volume();
        }
        Assert.assertEquals("", total, dodTest2.totalVolume(), .001);
    }

    @Test
    public void averageSurfaceAreaTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        double total = 0;
        for (int i = 0; i < arrSizeTest; i++) {
            total += (dodObjList[i].surfaceArea()) / arrSizeTest;
        }
        Assert.assertEquals("", total, dodTest2.averageSurfaceArea(), .001);
    }

    @Test
    public void averageVolumeTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        double total = 0;
        for (int i = 0; i < arrSizeTest; i++) {
            total += (dodObjList[i].volume()) / arrSizeTest;
        }
        Assert.assertEquals("", total, dodTest2.averageVolume(), .0001);
    }

    @Test
    public void averageSurfaceToVolumeRatioTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        double total = 0;
        for (int i = 0; i < arrSizeTest; i++) {
            total += dodObjList[i].surfaceToVolumeRatio()
                    / arrSizeTest;
        }
        Assert.assertEquals("", total, dodTest2.averageSurfaceToVolumeRatio(), .0001);
    }

    @Test
    public void toStringTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
        }
        Assert.assertEquals("", true, dodObjList[4].toString().contains(" with 30 edges of length "));
    }

    @Test
    public void summaryInfoTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        Assert.assertEquals("", true, dodTest2.summaryInfo().contains("Total Volume: "));
    }

    @Test
    public void getListTest() throws Exception {
        setUp();
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        Assert.assertArrayEquals("", dodObjList, dodTest2.getList());
    }

    // FIXME: 3/27/2017 fuck this.
    @Test
    public void readFileTest() throws IOException {
        DodecahedronList2 dodList2 = new DodecahedronList2("test list", null, 0);
        dodList2 = dodList2.readFile("dodecahedron_data_1.txt");
        Assert.assertEquals("", "Dodecahedron Test List", dodList2.getName());
    }

    @Test
    public void addDodecahedronTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        Dodecahedron dTrue = new Dodecahedron("test", "cyan", 2.5);
        dodTest2.addDodecahedron("test", "cyan", 2.5);

        Assert.assertEquals("", dTrue ,dodObjList[arrSizeTest]);
    }

    @Test
    public void findDodecahedronTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        Dodecahedron dTrue = new Dodecahedron("test4", "color4", 4.25);
        Assert.assertEquals("", dTrue, dodTest2.findDodecahedron("test4"));
    }

    @Test
    public void deleteDodecahedronTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        dodTest2.deleteDodecahedron("test4");
        Dodecahedron dTrue = new Dodecahedron("test2", "color2", 2.25);
        Assert.assertFalse("", dTrue == dodTest2.findDodecahedron("test2"));
    }

    @Test
    public void editDodecahedronTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        dodTest2.editDodecahedron("test4", "cyan", 425);
        Dodecahedron dTrue = new Dodecahedron("test4", "cyan", 425);
        Assert.assertEquals("", dTrue, dodTest2.findDodecahedron("test4"));
    }

    @Test
    public void findDodecahedronWithShortestEdgeTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        Dodecahedron dTrue = new Dodecahedron("test0", "color0", .25);
        Assert.assertEquals("", dTrue, dodTest2.findDodecahedronWithShortestEdge());
    }

    @Test
    public void findDodecahedronWithLongestEdgeTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        Dodecahedron dTrue = new Dodecahedron("test4", "color4", 4.25);
        Assert.assertEquals("", dTrue, dodTest2.findDodecahedronWithLongestEdge());
    }

    @Test
    public void findDodecahedronWithSmallestVolumeTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        Dodecahedron dTrue = new Dodecahedron("test0", "color0", .25);
        Assert.assertEquals("", dTrue, dodTest2.findDodecahedronWithSmallestVolume());
    }

    @Test
    public void findDodecahedronWithLargestVolumeTest() throws Exception {
        setUp();
        for (int i = 0; i < 5; i++) {
            Dodecahedron dodObj = new Dodecahedron("test"+i, "color"+i, i+.25);
            dodObjList[i] = dodObj;
            arrSizeTest++;
        }
        DodecahedronList2 dodTest2 = new DodecahedronList2(listName, dodObjList, arrSizeTest);
        Dodecahedron dTrue = new Dodecahedron("test4", "color4", 4.25);
        Assert.assertEquals("", dTrue, dodTest2.findDodecahedronWithLargestVolume());
    }
}