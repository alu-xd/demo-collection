import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.command.Command;
import org.apache.sshd.server.config.keys.DefaultAuthorizedKeysAuthenticator;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.shell.ProcessShellCommandFactory;
import org.apache.sshd.server.subsystem.sftp.SftpSubsystemFactory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestServer {

    public static void main(String[] args) {
        SshServer sshServer = SshServer.setUpDefaultServer();
        sshServer.setPort(12345);

        //*give host key generator a path, when sshd server restart, the same key will be load and used to authenticate the server
        sshServer.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(Paths.get("hostkey.ser")));

        sshServer.setPasswordAuthenticator((username, password, session) -> {
            System.out.println("authen:  user=" + username + "  password=" + password);
            if ("bellring".equals(username) && "123456".equals(password))
                return true;
            return false;
        });

        List<NamedFactory<Command>> namedFactoryList = new ArrayList<NamedFactory<Command>>();
        namedFactoryList.add(new SftpSubsystemFactory());
        sshServer.setSubsystemFactories(namedFactoryList);
        sshServer.setCommandFactory(new ProcessShellCommandFactory());
//        sshServer.setShellFactory(new ProcessShellFactory());


        //use file ~/.ssh/authorized_keys
        sshServer.setPublickeyAuthenticator(new DefaultAuthorizedKeysAuthenticator(false));

        try {
            sshServer.start();
            while (true) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
