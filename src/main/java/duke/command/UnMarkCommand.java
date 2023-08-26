package duke.command;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.DukeException;
import duke.TaskList;
import java.io.IOException;

/**
 * Represents a command to unmark a task as done.
 */
public class UnMarkCommand extends Command {

    /** Index of the task to unmark in the task list. */
    private final int taskIndex;

    /**
     * Constructs a new UnMarkCommand with the specified task index.
     *
     * @param taskIndex Index of the task in the task list to unmark as done.
     */
    public UnMarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Indicates whether this command should terminate the application.
     *
     * @return false since this command does not exit the application.
     */
    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * Executes the unmark command by unmarking the specified task in the task list.
     *
     * @param tasks   The list of tasks.
     * @param ui      The user interface used to interact with the user.
     * @param storage The storage system used to save and load tasks.
     * @throws IOException    If there's an error saving the tasks.
     * @throws DukeException  If there's an error related to Duke's operation, such as invalid task number.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException, DukeException {
        if (taskIndex < 0 || taskIndex >= tasks.getSize()) {
            throw new DukeException("Invalid input number. :( Please provide a valid task number.");
        }

        tasks.unmark(taskIndex);  // assuming the method to unmark the task exists
        ui.showUnmarkedTask(tasks.getTask(taskIndex));  // assuming a method to show the unmarked task exists in Ui
        storage.save(tasks);  // assuming a method to save tasks exists
    }
}