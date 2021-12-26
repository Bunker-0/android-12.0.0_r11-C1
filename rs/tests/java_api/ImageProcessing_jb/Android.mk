#
# Copyright (C) 2009 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_STATIC_JAVA_LIBRARIES := androidx.test.rules
LOCAL_JAVA_LIBRARIES := android.test.runner.stubs android.test.base.stubs

LOCAL_MODULE_TAGS := tests
LOCAL_COMPATIBILITY_SUITE += device-tests

LOCAL_SRC_FILES := $(call all-java-files-under, src) \
                   $(call all-renderscript-files-under, src)

LOCAL_PACKAGE_NAME := ImageProcessingJB
LOCAL_LICENSE_KINDS := SPDX-license-identifier-Apache-2.0
LOCAL_LICENSE_CONDITIONS := notice
LOCAL_SDK_VERSION := current

include $(BUILD_PACKAGE)