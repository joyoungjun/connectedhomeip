/*
 *
 *    Copyright (c) 2020 Project CHIP Authors
 *    Copyright (c) 2018 Nest Labs, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

#ifndef CHIP_DEVICE_ERROR_H
#define CHIP_DEVICE_ERROR_H

#define CHIP_DEVICE_ERROR_MIN 11000000
#define CHIP_DEVICE_ERROR_MAX 11000999
#define _CHIP_DEVICE_ERROR(e) (CHIP_DEVICE_ERROR_MIN + (e))

/**
 *  @def CHIP_DEVICE_ERROR_CONFIG_NOT_FOUND
 *
 *  @brief
 *    The requested configuration value was not found.
 *
 */
#define CHIP_DEVICE_ERROR_CONFIG_NOT_FOUND _CHIP_DEVICE_ERROR(1)

/**
 *  @def CHIP_DEVICE_ERROR_NOT_SERVICE_PROVISIONED
 *
 *  @brief
 *    The device has not been service provisioned.
 *
 */
#define CHIP_DEVICE_ERROR_NOT_SERVICE_PROVISIONED _CHIP_DEVICE_ERROR(2)

/**
 *  @def CHIP_DEVICE_ERROR_SOFTWARE_UPDATE_ABORTED
 *
 *  @brief
 *    The software update was aborted by application
 *
 */
#define CHIP_DEVICE_ERROR_SOFTWARE_UPDATE_ABORTED _CHIP_DEVICE_ERROR(3)

/**
 *  @def CHIP_DEVICE_ERROR_SOFTWARE_UPDATE_IGNORED
 *
 *  @brief
 *    The software update was ignored by application.
 *
 */
#define CHIP_DEVICE_ERROR_SOFTWARE_UPDATE_IGNORED _CHIP_DEVICE_ERROR(4)

#endif // CHIP_DEVICE_ERROR_H
