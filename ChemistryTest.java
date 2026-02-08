public class ChemistryTest {
    private LabTest[] tests;
    private int count;

    public ChemistryTest() {
        tests = new LabTest[30]; 
        count = 0;
    }

    public void addTest(LabTest t) {
        if (count < tests.length) {
            tests[count] = t;
            count++;
        }
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
            tests[i] = null;
        }
        count = 0;
    }
}
// variable initialization for labtest
abstract class LabTest {
    String testName;
    String unit;
    Double result;
    ReferenceRange maleRange;
    ReferenceRange femaleRange;

    public LabTest(String testName, String unit) {
        this.testName = testName;
        this.unit = unit;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getRangeString(String sex) {
        ReferenceRange r = sex.equals("Male") ? maleRange : femaleRange;
        return r.toString() + " " + unit + " (" + sex + ")";
    }

    public String evaluate(String sex) {
        ReferenceRange r = sex.equals("Male") ? maleRange : femaleRange;

        if (r.lower == null) {
            return (result <= r.upper) ? "NORMAL" : "HIGH";
        }

        if (result < r.lower) return "LOW";
        if (result > r.upper) return "HIGH";
        return "NORMAL";
    }
}






// TEST RANGE CLASSES
class ReferenceRange {
    Double lower;
    Double upper;

    public ReferenceRange(Double lower, Double upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public String toString() {
        if (lower == null) return "< " + upper;
        return lower + " - " + upper;
    }
}


class FastingBloodSugar extends LabTest {
    public FastingBloodSugar() {
        super("FBS", "mg/dL");
        this.maleRange = new ReferenceRange(74.0, 100.0);
        this.femaleRange = new ReferenceRange(74.0, 100.0);
    }
}


class RandomBloodSugar extends LabTest {
    public RandomBloodSugar() {
        super("RBS", "mg/dL");
        this.maleRange = new ReferenceRange(70.0, 140.0);
        this.femaleRange = new ReferenceRange(70.0, 140.0);
    }
}


class TotalCholesterol extends LabTest {
    public TotalCholesterol() {
        super("Total Cholesterol", "mg/dL");
        this.maleRange = new ReferenceRange(150.0, 200.0);
        this.femaleRange = new ReferenceRange(150.0, 200.0);
    }
}

class HDL extends LabTest {
    public HDL() {
        super("HDL", "mg/dL");
        this.maleRange = new ReferenceRange(35.0, 80.0);
        this.femaleRange = new ReferenceRange(42.0, 88.0);
    }
}

class LDL extends LabTest {
    public LDL() {
        super("LDL", "mg/dL");
        this.maleRange = new ReferenceRange(50.0, 130.0);
        this.femaleRange = new ReferenceRange(50.0, 130.0);
    }
}

class Triglycerides extends LabTest {
    public Triglycerides() {
        super("Triglycerides", "mg/dL");
        this.maleRange = new ReferenceRange(60.0, 165.0);
        this.femaleRange = new ReferenceRange(40.0, 140.0);
    }
}

class Creatinine extends LabTest {
    public Creatinine() {
        super("Creatinine", "mg/dL");
        this.maleRange = new ReferenceRange(0.9, 1.3);
        this.femaleRange = new ReferenceRange(0.6, 1.2);
    }
}

class UricAcid extends LabTest {
    public UricAcid() {
        super("Uric Acid", "mg/dL");
        this.maleRange = new ReferenceRange(3.5, 7.2);
        this.femaleRange = new ReferenceRange(2.6, 6.0);
    }
}

class BUN extends LabTest {
    public BUN() {
        super("BUN", "mg/dL");
        this.maleRange = new ReferenceRange(6.0, 20.0);
        this.femaleRange = new ReferenceRange(6.0, 20.0);
    }
}

class AST extends LabTest {
    public AST() {
        super("AST/SGOT", "U/L");
        this.maleRange = new ReferenceRange(null, 46.0);
        this.femaleRange = new ReferenceRange(null, 46.0);
    }
}

class ALT extends LabTest {
    public ALT() {
        super("ALT/SGPT", "U/L");
        this.maleRange = new ReferenceRange(null, 49.0);
        this.femaleRange = new ReferenceRange(null, 49.0);
    }
}

class Sodium extends LabTest {
    public Sodium() {
        super("Sodium", "mEq/L");
        this.maleRange = new ReferenceRange(135.0, 145.0);
        this.femaleRange = new ReferenceRange(135.0, 145.0);
    }
}

class Potassium extends LabTest {
    public Potassium() {
        super("Potassium", "mEq/L");
        this.maleRange = new ReferenceRange(3.5, 5.0);
        this.femaleRange = new ReferenceRange(3.5, 5.0);
    }
}

class Chloride extends LabTest {
    public Chloride() {
        super("Chloride", "mEq/L");
        this.maleRange = new ReferenceRange(96.0, 110.0);
        this.femaleRange = new ReferenceRange(96.0, 110.0);
    }
}

class TotalCalcium extends LabTest {
    public TotalCalcium() {
        super("Total Calcium", "mg/dL");
        this.maleRange = new ReferenceRange(8.6, 10.28);
        this.femaleRange = new ReferenceRange(8.6, 10.28);
    }
}

class IonizedCalcium extends LabTest {
    public IonizedCalcium() {
        super("Ionized Calcium", "mg/dL");
        this.maleRange = new ReferenceRange(4.4, 5.2);
        this.femaleRange = new ReferenceRange(4.4, 5.2);
    }
}
