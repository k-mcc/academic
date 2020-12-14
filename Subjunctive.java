public class Subjunctive {

  public static void main (String[] args) {
    Subjunctive word = new Subjunctive("correr");
    String[] subjunctive = word.getSubjunctive();
    System.out.println("Subjunctive: ");
    for (int i = 0; i < 6; i++) {
      System.out.println(subjunctive[i]);
    }
  }

  private String infinitive;
  private String yoStem;
  private String stemChange;
  private String[] subjunctive;

  // verbs without stem change or irregular yo form
  public Subjunctive(String infinitive) {
    this.infinitive = infinitive;
    this.stemChange = ""; //null
    this.yoStem = ""; //null
    this.subjunctive = findSubjunctive();
  }

  public Subjunctive(String infinitive, String yoStem, String stemChange) {
    this.infinitive = infinitive;
    this.stemChange = stemChange; // "ie", "ue", "i", or "u"
    this.yoStem = yoStem;
    this.subjunctive = findSubjunctive();
  }

  private String[] findSubjunctive() {

    String[] eEnds = {"e","es","e","emos","éis","en"};
    String[] aEnds = {"a","as","a","amos","áis","an"};

    if (this.infinitive == "dar")   {
      String[] forms = {"dé","des","dé","demos","deis","den"};
      return forms;
    }
    if (this.infinitive == "ir") {
      String[] forms = {"vaya","vayas","vaya","vayamos","vayáis","vayan"};
      return forms;
    }
    if (this.infinitive == "ser") {
      String[] forms = {"sea","seas","sea","seamos","seáis","sean"};
      return forms;
    }
    if (this.infinitive == "haber") {
      String[] forms = {"haya","hayas","haya","hayamos","hayáis","hayan"};
      return forms;
    }
    if (this.infinitive == "estar") {
      String[] forms = {"esté","estés","esté","estemos","estéis","estén"};
      return forms;
    }
    if (this.infinitive == "saber") {
      String[] forms = {"sepa","sepas","sepa","sepamos","sepáis","sepan"};
      return forms;
    }

    String ending = infinitive.substring(infinitive.length()-3,infinitive.length()-1);
    String[] forms = new String[6];

    // Verbs ending in -car, -gar, and -zar
    if (ending.equals("ca") || ending.equals("ga") || ending.equals("za")) {
      String stem = infinitive.substring(0, infinitive.length()-3);
      String sub;
      if (ending.equals("ca")) sub = "qu";
      else if (ending.equals("ga")) sub = "gu";
      else sub = "c";
      for (int i = 0; i < 6; i++) forms[i] = "" + stem + sub + eEnds[i];
      return forms;
    }

    ending = "" + ending.charAt(1);

    if ((ending.equals("a") || ending.equals("e")) && (stemChange.equals("ie") || stemChange.equals("ue"))) {
      String stem = infinitive.substring(0, infinitive.length()-2);
      if (ending.equals("a")) {
        for(int i = 0; i < 6; i++) {
          if (i == 3 || i ==4) forms[i] = stem + eEnds[i];
          else forms[i] = yoStem + eEnds[i];
        }
      }
      else if (ending.equals("e")) {
        for(int j = 0; j < 6; j++) {
          if (j == 3 || j == 4) forms[j] = stem + aEnds[j];
          else forms[j] = yoStem + aEnds[j];
        }
      }
      return forms;
    }

    if ((ending.equals("a") || ending.equals("e")) && (stemChange.equals("ie") || stemChange.equals("ue"))) {
      String stem = infinitive.substring(0, infinitive.length()-2);
      if (ending.equals("a")) {
        for(int i = 0; i < 6; i++) {
          if (i == 3 || i ==4) forms[i] = stem + eEnds[i];
          else forms[i] = yoStem + eEnds[i];
        }
        return forms;
      }
      if (ending.equals("i")  && (stemChange.equals("ie") || stemChange.equals("ue"))) {
        for(int i = 0; i < 6; i++) {
          if (i == 3 || i ==4) forms[i] = stem + aEnds[i];
          forms[i] = yoStem + aEnds[i];
        }
        return forms;
      }
      if (ending.equals("i")  && (stemChange.equals("i") || stemChange.equals("u"))) {
        for(int i = 0; i < 6; i++) forms[i] = yoStem + aEnds[i];
        return forms;
      }
    }

    else if (!yoStem.equals("")) {
      if (ending.equals("i") || ending.equals("e")) {
        for(int i = 0; i < 6; i++) forms[i] = yoStem + aEnds[i];
      }
      else if (ending.equals("a")) {
        for(int i = 0; i < 6; i++) forms[i] = yoStem + eEnds[i];
      }
      return forms;
    }

    else {
      String stem = infinitive.substring(0, infinitive.length()-2);
      if (ending.equals("i") || ending.equals("e")) {
        for(int i = 0; i < 6; i++) forms[i] = stem + aEnds[i];
      }
      else if (ending.equals("a")) {
        for(int i = 0; i < 6; i++) forms[i] = stem + eEnds[i];
      }
      return forms;
    }

    return forms;
  }

  public String[] getSubjunctive() {
    return this.subjunctive;
  }





}
