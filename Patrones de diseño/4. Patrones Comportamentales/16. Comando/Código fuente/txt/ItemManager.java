import java.util.*;

public class ItemManager {
  CommandInterface command;

  public void setCommand(CommandInterface c) {
    command = c;
  }

  public void process() {
    command.execute();
  }
}
