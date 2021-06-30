package reporters;

import com.google.inject.Inject;

import java.util.List;

class CountReporter {

    @Inject
    static ILineReporter reporter;

    int count=0;

    public void reportThisMany(List<String> lines){

        for(String line : lines){
            reporter.report(line);
            count++;
        }
    }

    public int getCount(){
        return count;
    }

}
