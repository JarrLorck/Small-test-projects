 
2. Let's say I have a database of scripts. Each script has an arbitrary number of dependencies.  The dependencies are expressed as a list of scriptIds that need to be executed before a given script.  There are no circular dependencies.  I want to come up with an execution plan so that I can run all of the scripts in a sane order.  Below is the script representation.  

```
package com.sixt.platform.interview;
import java.util.List;

public class VulnerabilityScript {

   private final int scriptId;
   private final List<Integer> dependencies;

   public VulnerabilityScript(int scriptId, List<Integer> dependencies) {
       this.scriptId = scriptId;
       this.dependencies = dependencies;
   }

   public int getScriptId() {
       return scriptId;
   }

   public List<Integer> getDependencies() {
       return dependencies;
   }

}
```
