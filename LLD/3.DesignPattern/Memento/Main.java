import java.util.Stack;

class TextEditorMemento {
    private final String state;

    public TextEditorMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

//Originator – TextEditor

class TextEditor {
    private String content = "";

    public void type(String newText) {
        content += newText;
        System.out.println("Typed: \"" + newText + "\"");
    }

    public String getContent() {
        return content;
    }

    public TextEditorMemento save() {
        System.out.println("Saving state: \"" + content + "\"");
        return new TextEditorMemento(content);
    }

    public void restore(TextEditorMemento memento) {
        content = memento.getState();
        System.out.println("Restored state to: \"" + content + "\"");
    }
}

//Caretaker – TextEditorUndoManager
class TextEditorUndoManager {
    private final Stack<TextEditorMemento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public int historySize() {
        return history.size();
    }
}




public class Main {

    public static void main(String[] args) {
        
         TextEditor editor = new TextEditor();
        TextEditorUndoManager undoManager = new TextEditorUndoManager();

        editor.type("Hello");
        undoManager.save(editor);

        editor.type(" World");
        undoManager.save(editor);

        editor.type("!");
        System.out.println("Current: " + editor.getContent());

        System.out.println("\n--- Undo 1 ---");
        undoManager.undo(editor);
        System.out.println("Content: " + editor.getContent());

        System.out.println("\n--- Undo 2 ---");
        undoManager.undo(editor);
        System.out.println("Content: " + editor.getContent());

        System.out.println("\n--- Undo 3 ---");
        undoManager.undo(editor);
    }
}