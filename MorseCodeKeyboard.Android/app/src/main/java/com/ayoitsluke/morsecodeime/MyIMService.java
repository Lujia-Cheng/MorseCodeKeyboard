package com.ayoitsluke.morsecodeime;

import android.inputmethodservice.InputMethodService;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;


public class MyIMService extends InputMethodService implements OnClickListener {
    private final boolean capsLock = false;
    private boolean caps = false;
    private String typed = ""; // Queue of char sequence


    public MyIMService() {
        super();
    }

    public View onCreateInputView() {
        View view = this.getLayoutInflater().inflate(R.layout.keys_layout, null);
        view.setOnKeyListener((View.OnKeyListener) this);
        return view;
    }

    public void onStartInputView(EditorInfo info, boolean restarting) {
        super.onStartInputView(info, restarting);
    }


    public View onCreateCandidatesView() {
        // TODO
        return super.onCreateCandidatesView();
    }

    public void onClick(View v) {
        if (!(v instanceof Button)) return;
        Button b = (Button) v;
// check view tag
        if (b.getTag().equals("alphanumeric")) {
            // if tag is "char" then send it to InputConnection
            inputText(b.getText());
        } else {
            // otherwise is a system commands key
            handleOperation((CharSequence) b.getTag());
        }
    }

    /**
     * @param cs
     */
    private void inputText(CharSequence cs) {
        if (cs.length() != 1) {
            throw new IllegalArgumentException(cs.toString());
        }
        InputConnection ic = this.getCurrentInputConnection();
        if (ic == null) {
            return;
        }
        CharSequence text = this.caps ? (CharSequence) cs.toString().toUpperCase() : cs;
        this.typed += cs;
        ic.setComposingText(text, 1);
        ic.commitText(text, 1);
    }


    private void handleOperation(CharSequence charSequence) {
        InputConnection ic = this.getCurrentInputConnection();
        if (ic == null) return;
        switch ((String) charSequence) {
            case "shift":
                caps = !caps;
                break;
            case "backspace":
                if (TextUtils.isEmpty(ic.getSelectedText(0))) {
                    ic.deleteSurroundingText(1, 0);
                } else {
                    ic.commitText((CharSequence) "", 1);
                }
                ic.deleteSurroundingText(1, 0);
                break;
            case "symbol":
                this.getLayoutInflater().inflate(R.layout.symbol_layout, (ViewGroup) null);
                break;
            case "setting":
                // TODO setting
                break;
            case "emoji":
                // TODO
                break;
            case "space":
                ic.commitText((CharSequence) " ", 1);
                break;
            case "done":
                Feedback fb = new Feedback(this.typed);
                break;
            default:
                // TODO
                try {
                    throw new Exception("Unidentified key");
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
        return;
    }
}

