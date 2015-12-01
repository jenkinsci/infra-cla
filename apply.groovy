#!/usr/bin/env groovy
#
# Add all the people who signed ICLA into the right group
#
@Grab('org.kohsuke:github-api:1.70')
import org.kohsuke.github.*;

def gh = GitHub.connect();
def o = gh.getOrganization("jenkinsci");
def t = o.getTeamByName("Core");
def members = t.getMembers()*.login;

println members;

new File("collected/icla").eachDir { m ->
    def p = new Properties();
    p.load(new FileReader(new File(m,"committer.properties")));

    String id = p.getProperty("github");
    if (id==null)   return; // no GitHub ID
    
    if (!members.contains(id)) {
        println "Adding ${id} from ${m}"
        t.add(gh.getUser(id))
    }
}

