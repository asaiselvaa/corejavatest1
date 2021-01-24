import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test1 {
    public static void main(String[] abc) {
        System.out.println("Hai there");

        List<String> myList = Arrays.asList("DeptA","DeptB","DeptC","DeptE","DeptA","DeptA");
        List v = myList.parallelStream()
                .filter(h->h.equals("DeptA"))
                .peek(s->s.toLowerCase())
                .collect(Collectors.toList());
        System.out.println(v);

    }
}
