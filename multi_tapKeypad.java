public class multi_tapKeypad {
    public static int presses(String phrase) {
      int sum = 0;
      for(char c: phrase.toLowerCase().toCharArray()){
        switch(c){
            case '1':
            case 'a':
            case 'd':
            case 'g':
            case 'j':
            case 'm':
            case 'p':
            case 't':
            case 'w':
            case '*':
            case ' ':
            case '#':
                sum += 1;
                break;
            case 'b':
            case 'e':
            case 'h':
            case 'k':
            case 'n':
            case 'q':
            case 'u':
            case 'x':
            case '0':
                sum += 2;
                break;
            case 'c':
            case 'f':
            case 'i':
            case 'l':
            case 'o':
            case 'r':
            case 'v':
            case 'y':
                sum += 3;
                break;
            case 's':
            case 'z':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '8':
                sum += 4;
                break;
            case '7':
            case '9':
                sum += 5;
                break;
        }
      }
      return sum;
    }
    public static void main(String[] args) {
        System.out.println(presses("LOL"));
    }
  }
