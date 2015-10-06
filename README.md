# Jenkins project CLA

`icla.txt` and `ccla.txt` contain the CLA paper. In particular,
[icla.txt](https://raw.github.com/jenkinsci/infra-cla/master/icla.txt) and [ccla.txt](https://raw.github.com/jenkinsci/infra-cla/approved/ccla.txt) in the `approved` branch
are the official versions that people should be using.
See [the governance document](https://wiki.jenkins-ci.org/display/JENKINS/Governance+Document) for the background.

# How to file CLA
## Individual CLA
For each committer that works on the core, ICLA must be in place:

* Fork this repository, and check it out locally
* Create a directory under `collected/icla/YOURNAME` where YOURNAME is [your Jenkins community ID](http://jenkins-ci.org/account)
* Have ICLA printed, signed, scanned back to PDF. Encrypt it (see below) and put it as `collected/icla/YOURNAME/cla.pdf.asc`
* Add a property file at `collected/icla/YOURNAME/committer.properties` and list your name, email address, and GitHub ID.
* If your company has a signed CCLA in place, create a symlink at `collected/icla/YOURNAME/ccla` to the corresponding `../../ccla/COMPANY` directory.
* File your fork as a pull request

There should be a plenty of examples of this in [our PR section](https://github.com/jenkinsci/infra-cla/pulls?q=is%3Apr+is%3Aclosed) .

To encrypt your CLA, you need gpg. First, obtain the public key of the Jenkins board:

    curl https://raw.github.com/jenkinsci/infra-cla/approved/publicKey.asc | gpg --import

The command to sign it is:

    gpg --encrypt --sign --armor -r "Jenkins Project CLA" < cla.pdf > cla.pdf.asc


## Corporate CLA
If you work on Jenkins core on behalf of your employer, your company needs to have CCLA in place. Have CCLA printed, signed, scanned back to PDF, then send it to `jenkinsci-cla@googlegroups.com` along with [your account on Jenkins](https://jenkins-ci.org/account).

# How to accept PR
A board member accepts a submitted PR via the following step.

* Check that the submission is in order
* Check that `cla.pdf.asc` can be indeed decrypted, and make sure it has valid content
* Merge the PR
* Create a signed tag (`git tag -s`) on the merge commit to create a proof
* Add the person to [the core team](https://github.com/orgs/jenkinsci/teams/core)
