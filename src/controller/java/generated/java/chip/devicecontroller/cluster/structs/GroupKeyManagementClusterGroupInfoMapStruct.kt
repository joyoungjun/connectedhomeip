/*
 *
 *    Copyright (c) 2023 Project CHIP Authors
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
package chip.devicecontroller.cluster.structs

import chip.devicecontroller.cluster.*
import chip.tlv.AnonymousTag
import chip.tlv.ContextSpecificTag
import chip.tlv.Tag
import chip.tlv.TlvParsingException
import chip.tlv.TlvReader
import chip.tlv.TlvWriter

import java.util.Optional

class GroupKeyManagementClusterGroupInfoMapStruct (
    val groupId: Int,
    val endpoints: List<Int>,
    val groupName: Optional<String>,
    val fabricIndex: Int) {
  override fun toString(): String  = buildString {
    append("GroupKeyManagementClusterGroupInfoMapStruct {\n")
    append("\tgroupId : $groupId\n")
    append("\tendpoints : $endpoints\n")
    append("\tgroupName : $groupName\n")
    append("\tfabricIndex : $fabricIndex\n")
    append("}\n")
  }

  fun toTlv(tag: Tag, tlvWriter: TlvWriter) {
    tlvWriter.apply {
      startStructure(tag)
      put(ContextSpecificTag(TAG_GROUP_ID), groupId)
      startList(ContextSpecificTag(TAG_ENDPOINTS))
      for (item in endpoints.iterator()) {
        put(AnonymousTag, item)
      }
      endList()
      if (groupName.isPresent) {
      val optgroupName = groupName.get()
      put(ContextSpecificTag(TAG_GROUP_NAME), optgroupName)
    }
      put(ContextSpecificTag(TAG_FABRIC_INDEX), fabricIndex)
      endStructure()
    }
  }

  companion object {
    private const val TAG_GROUP_ID = 1
    private const val TAG_ENDPOINTS = 2
    private const val TAG_GROUP_NAME = 3
    private const val TAG_FABRIC_INDEX = 254

    fun fromTlv(tag: Tag, tlvReader: TlvReader) : GroupKeyManagementClusterGroupInfoMapStruct {
      tlvReader.enterStructure(tag)
      val groupId = tlvReader.getInt(ContextSpecificTag(TAG_GROUP_ID))
      val endpoints = buildList<Int> {
      tlvReader.enterList(ContextSpecificTag(TAG_ENDPOINTS))
      while(!tlvReader.isEndOfContainer()) {
        add(tlvReader.getInt(AnonymousTag))
      }
      tlvReader.exitContainer()
    }
      val groupName = if (tlvReader.isNextTag(ContextSpecificTag(TAG_GROUP_NAME))) {
      Optional.of(tlvReader.getString(ContextSpecificTag(TAG_GROUP_NAME)))
    } else {
      Optional.empty()
    }
      val fabricIndex = tlvReader.getInt(ContextSpecificTag(TAG_FABRIC_INDEX))
      
      tlvReader.exitContainer()

      return GroupKeyManagementClusterGroupInfoMapStruct(groupId, endpoints, groupName, fabricIndex)
    }
  }
}
