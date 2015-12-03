# Butter_Knife_Example
Android Application With Butter Knife Library.
In this project, you'll learn how to integrate the Butter Knife library in your projects to easily instantiate the views in your layout in your application's code.

# Introduction
In every Android application, you have to use the **findViewById()** method for each view in the layout that you want to use in your application's code. But as applications' designs get more complex layouts, the call to this method becomes repetitive and this is where the Butter Knife library comes in.

The Butter Knife library, developer and maintained by **Jake Wharton (Square Inc.)**, has annotations that help developers to instantiate the views from our activity or fragment. It also has annotations to handle events like onClick(), onLongClick(), etc.

In the sample project of this tutorial, you can see a sample application with one activity and one fragment with an implementation using the Butter Knife library and a regular implementation. Let's explore the steps involved to integrate the Butter Knife library.

# 1. Using the Butter Knife Library
# Step 1: Add the Dependency
Add the following dependency to the project's build.gradle file:

     1. compile 'com.jakewharton:butterknife:6.1.0+'

Next, synchronize your project with this file by pressing the synchronize button.

#Step 2: Use the Annotations

```
public class LogInActivity extends AppCompatActivity {
    @Bind(R.id.etEmailInLogIn)
    EditText etEmail;
    @Bind(R.id.etPasswordInLogIn)
    EditText etPassword;
    @Bind(R.id.tvSignUp)
    TextView tvSignUp;
    @Bind(R.id.btnLogIn)
    Button btnLogIn;
    ...........

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      ......
    }
}

```
#Step 3: Bind Views
In the onCreate() method of the activity, before using any the views, call bind on the Butterknife object.
```
 @Override
    protected void onCreate(Bundle savedInstanceState) {
       ........
        ButterKnife.bind(this);
       ........
    }
```
If you are using fragments, you have to specify the source of the views in the onCreateView() method as shown below.
 1. View view = inflater.inflate(R.layout.sample_fragment, null);
 2. ButterKnife.inject(this, view);

You can now start using the views in your application's code. Butter Knife will handle the instantiation of every single view for you.

# LISTENER BINDING 
Listeners can also automatically be configured onto methods.
```
@OnClick(R.id.btnLogIn)
    public void btnLogInClicked() {

        String email = etEmail.getText().toString().toLowerCase().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty() && password.isEmpty()) {
            Snackbar.make(findViewById(android.R.id.content), "You Have To Enter Your Email And Password!!", Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.RED)
                    .show();
        } else {
            Snackbar.make(findViewById(android.R.id.content), "Log In Successful", Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.GREEN)
                    .show();
            Toast.makeText(LogInActivity.this, "Email: "+email, Toast.LENGTH_SHORT).show();
        }

```
# RESOURCE BINDING
Bind pre-defined resources with @BindBool, @BindColor, @BindDimen, @BindDrawable, @BindInt, @BindString, which binds an R.bool ID (or your specified type) to its corresponding field.
```
class ExampleActivity extends Activity {
  @BindString(R.string.title) String title;
  @BindDrawable(R.drawable.graphic) Drawable graphic;
  @BindColor(R.color.red) int red; // int or ColorStateList field
  @BindDimen(R.dimen.spacer) Float spacer; // int (for pixel size) or float (for exact value) field
  // ...
}

```
