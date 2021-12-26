/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.view;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.RemoteException;

import com.android.internal.util.DataClass;

import java.util.ArrayList;

/** @hide */
@DataClass(genToString = true, genGetters = true)
public class ScrollCaptureResponse implements Parcelable {

    /** Developer-facing human readable description of the result. */
    @NonNull
    private String mDescription = "";

    // Remaining fields are non-null when isConnected() == true

    /** The active connection for a successful result. */
    @Nullable
    @DataClass.MaySetToNull
    private IScrollCaptureConnection mConnection = null;

    /** The bounds of the window within the display */
    @Nullable
    private Rect mWindowBounds = null;

    /** The bounds of the scrolling content, in window space. */
    @Nullable
    private Rect mBoundsInWindow = null;

    /** The current window title. */
    @Nullable
    private String mWindowTitle = null;

    /** Carries additional logging and debugging information when enabled. */
    @NonNull
    @DataClass.PluralOf("message")
    private ArrayList<String> mMessages = new ArrayList<>();

    /** Whether an active connection is present. */
    public boolean isConnected() {
        return mConnection != null && mConnection.asBinder().isBinderAlive();
    }

    /** Closes a connection returned with this response. */
    public void close() {
        if (mConnection != null) {
            try {
                mConnection.close();
            } catch (RemoteException e) {
                // Ignore
            }
            mConnection = null;
        }
    }



    // Code below generated by codegen v1.0.22.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/frameworks/base/core/java/android/view/ScrollCaptureResponse.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    @DataClass.Generated.Member
    /* package-private */ ScrollCaptureResponse(
            @NonNull String description,
            @Nullable IScrollCaptureConnection connection,
            @Nullable Rect windowBounds,
            @Nullable Rect boundsInWindow,
            @Nullable String windowTitle,
            @NonNull ArrayList<String> messages) {
        this.mDescription = description;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mDescription);
        this.mConnection = connection;
        this.mWindowBounds = windowBounds;
        this.mBoundsInWindow = boundsInWindow;
        this.mWindowTitle = windowTitle;
        this.mMessages = messages;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mMessages);

        // onConstructed(); // You can define this method to get a callback
    }

    /**
     * Developer-facing human readable description of the result.
     */
    @DataClass.Generated.Member
    public @NonNull String getDescription() {
        return mDescription;
    }

    /**
     * The active connection for a successful result.
     */
    @DataClass.Generated.Member
    public @Nullable IScrollCaptureConnection getConnection() {
        return mConnection;
    }

    /**
     * The bounds of the window within the display
     */
    @DataClass.Generated.Member
    public @Nullable Rect getWindowBounds() {
        return mWindowBounds;
    }

    /**
     * The bounds of the scrolling content, in window space.
     */
    @DataClass.Generated.Member
    public @Nullable Rect getBoundsInWindow() {
        return mBoundsInWindow;
    }

    /**
     * The current window title.
     */
    @DataClass.Generated.Member
    public @Nullable String getWindowTitle() {
        return mWindowTitle;
    }

    /**
     * Carries additional logging and debugging information when enabled.
     */
    @DataClass.Generated.Member
    public @NonNull ArrayList<String> getMessages() {
        return mMessages;
    }

    @Override
    @DataClass.Generated.Member
    public String toString() {
        // You can override field toString logic by defining methods like:
        // String fieldNameToString() { ... }

        return "ScrollCaptureResponse { " +
                "description = " + mDescription + ", " +
                "connection = " + mConnection + ", " +
                "windowBounds = " + mWindowBounds + ", " +
                "boundsInWindow = " + mBoundsInWindow + ", " +
                "windowTitle = " + mWindowTitle + ", " +
                "messages = " + mMessages +
        " }";
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@NonNull android.os.Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        byte flg = 0;
        if (mConnection != null) flg |= 0x2;
        if (mWindowBounds != null) flg |= 0x4;
        if (mBoundsInWindow != null) flg |= 0x8;
        if (mWindowTitle != null) flg |= 0x10;
        dest.writeByte(flg);
        dest.writeString(mDescription);
        if (mConnection != null) dest.writeStrongInterface(mConnection);
        if (mWindowBounds != null) dest.writeTypedObject(mWindowBounds, flags);
        if (mBoundsInWindow != null) dest.writeTypedObject(mBoundsInWindow, flags);
        if (mWindowTitle != null) dest.writeString(mWindowTitle);
        dest.writeStringList(mMessages);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    protected ScrollCaptureResponse(@NonNull android.os.Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        byte flg = in.readByte();
        String description = in.readString();
        IScrollCaptureConnection connection = (flg & 0x2) == 0 ? null : IScrollCaptureConnection.Stub.asInterface(in.readStrongBinder());
        Rect windowBounds = (flg & 0x4) == 0 ? null : (Rect) in.readTypedObject(Rect.CREATOR);
        Rect boundsInWindow = (flg & 0x8) == 0 ? null : (Rect) in.readTypedObject(Rect.CREATOR);
        String windowTitle = (flg & 0x10) == 0 ? null : in.readString();
        ArrayList<String> messages = new ArrayList<>();
        in.readStringList(messages);

        this.mDescription = description;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mDescription);
        this.mConnection = connection;
        this.mWindowBounds = windowBounds;
        this.mBoundsInWindow = boundsInWindow;
        this.mWindowTitle = windowTitle;
        this.mMessages = messages;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mMessages);

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @NonNull Parcelable.Creator<ScrollCaptureResponse> CREATOR
            = new Parcelable.Creator<ScrollCaptureResponse>() {
        @Override
        public ScrollCaptureResponse[] newArray(int size) {
            return new ScrollCaptureResponse[size];
        }

        @Override
        public ScrollCaptureResponse createFromParcel(@NonNull android.os.Parcel in) {
            return new ScrollCaptureResponse(in);
        }
    };

    /**
     * A builder for {@link ScrollCaptureResponse}
     */
    @SuppressWarnings("WeakerAccess")
    @DataClass.Generated.Member
    public static class Builder {

        private @NonNull String mDescription;
        private @Nullable IScrollCaptureConnection mConnection;
        private @Nullable Rect mWindowBounds;
        private @Nullable Rect mBoundsInWindow;
        private @Nullable String mWindowTitle;
        private @NonNull ArrayList<String> mMessages;

        private long mBuilderFieldsSet = 0L;

        public Builder() {
        }

        /**
         * Developer-facing human readable description of the result.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setDescription(@NonNull String value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x1;
            mDescription = value;
            return this;
        }

        /**
         * The active connection for a successful result.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setConnection(@Nullable IScrollCaptureConnection value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x2;
            mConnection = value;
            return this;
        }

        /**
         * The bounds of the window within the display
         */
        @DataClass.Generated.Member
        public @NonNull Builder setWindowBounds(@NonNull Rect value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x4;
            mWindowBounds = value;
            return this;
        }

        /**
         * The bounds of the scrolling content, in window space.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setBoundsInWindow(@NonNull Rect value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x8;
            mBoundsInWindow = value;
            return this;
        }

        /**
         * The current window title.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setWindowTitle(@NonNull String value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x10;
            mWindowTitle = value;
            return this;
        }

        /**
         * Carries additional logging and debugging information when enabled.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setMessages(@NonNull ArrayList<String> value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x20;
            mMessages = value;
            return this;
        }

        /** @see #setMessages */
        @DataClass.Generated.Member
        public @NonNull Builder addMessage(@NonNull String value) {
            if (mMessages == null) setMessages(new ArrayList<>());
            mMessages.add(value);
            return this;
        }

        /** Builds the instance. This builder should not be touched after calling this! */
        public @NonNull ScrollCaptureResponse build() {
            checkNotUsed();
            mBuilderFieldsSet |= 0x40; // Mark builder used

            if ((mBuilderFieldsSet & 0x1) == 0) {
                mDescription = "";
            }
            if ((mBuilderFieldsSet & 0x2) == 0) {
                mConnection = null;
            }
            if ((mBuilderFieldsSet & 0x4) == 0) {
                mWindowBounds = null;
            }
            if ((mBuilderFieldsSet & 0x8) == 0) {
                mBoundsInWindow = null;
            }
            if ((mBuilderFieldsSet & 0x10) == 0) {
                mWindowTitle = null;
            }
            if ((mBuilderFieldsSet & 0x20) == 0) {
                mMessages = new ArrayList<>();
            }
            ScrollCaptureResponse o = new ScrollCaptureResponse(
                    mDescription,
                    mConnection,
                    mWindowBounds,
                    mBoundsInWindow,
                    mWindowTitle,
                    mMessages);
            return o;
        }

        private void checkNotUsed() {
            if ((mBuilderFieldsSet & 0x40) != 0) {
                throw new IllegalStateException(
                        "This Builder should not be reused. Use a new Builder instance instead");
            }
        }
    }

    @DataClass.Generated(
            time = 1614833185795L,
            codegenVersion = "1.0.22",
            sourceFile = "frameworks/base/core/java/android/view/ScrollCaptureResponse.java",
            inputSignatures = "private @android.annotation.NonNull java.lang.String mDescription\nprivate @android.annotation.Nullable @com.android.internal.util.DataClass.MaySetToNull android.view.IScrollCaptureConnection mConnection\nprivate @android.annotation.Nullable android.graphics.Rect mWindowBounds\nprivate @android.annotation.Nullable android.graphics.Rect mBoundsInWindow\nprivate @android.annotation.Nullable java.lang.String mWindowTitle\nprivate @android.annotation.NonNull @com.android.internal.util.DataClass.PluralOf(\"message\") java.util.ArrayList<java.lang.String> mMessages\npublic  boolean isConnected()\npublic  void close()\nclass ScrollCaptureResponse extends java.lang.Object implements [android.os.Parcelable]\n@com.android.internal.util.DataClass(genToString=true, genGetters=true)")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}
