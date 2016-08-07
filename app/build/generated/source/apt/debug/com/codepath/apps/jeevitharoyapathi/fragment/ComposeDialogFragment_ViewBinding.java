// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.jeevitharoyapathi.fragment;

import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.codepath.apps.jeevitharoyapathi.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ComposeDialogFragment_ViewBinding<T extends ComposeDialogFragment> implements Unbinder {
  protected T target;

  public ComposeDialogFragment_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mBody = finder.findRequiredViewAsType(source, R.id.NewTweet, "field 'mBody'", EditText.class);
    target.mCount = finder.findRequiredViewAsType(source, R.id.tvRemainingCharCount, "field 'mCount'", TextView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mBody = null;
    target.mCount = null;

    this.target = null;
  }
}
