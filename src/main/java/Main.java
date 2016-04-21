import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

import java.net.URL;

public class Main {

    public static void main(String[] args) throws KettleException {
        KettleEnvironment.init();
        URL ktrUrl = Main.class.getClassLoader().getResource("hello.ktr");
        TransMeta transMeta = new TransMeta(ktrUrl.getFile());
        Trans trans = new Trans(transMeta);
        trans.execute(args);
        trans.waitUntilFinished();
        if (trans.getErrors() > 0) {
            System.out.print( "Error Executing transformation" );
        }
    }

}