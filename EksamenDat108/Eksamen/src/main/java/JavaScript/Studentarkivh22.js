package bokanmeldese.eksamen23VbokanmeldserDat108.JavaScript;

public class Studentarkivh22 {
#studentarkiv = new Map();


    nystudent(student){
    const {id, fornavn,etternavn, tlf:liste} = student;

    if(!id || !etternavn || !fornavn ) return null;
    if(id.#studentarkiv.has(id)) return false;

    if(liste === undefined){
        this.#studentarkiv.set(id, {
            "fornavn" : fornavn,
            "etternavn" : etternavn,
        })
    } else {
        const tlf = new Set();
        liste.forEach(nummer => {tlf.add(nummer)});
        this.#studentarkiv.set(id, {
                    "fornavn" : fornavn,
                    "etternavn" : etternavn,
                    "tlf" : tlf
        });
    }

    return true;
    }

    hartelefon(id,telefonummer) {
    if(!this.#studentarkiv.has(id)) return null;
    const tlf = this.#studentarkiv.get(id)
    if(tlf === undefined )){
    return false;
    } else {
    return (tlf.has(telefonummer));
    }

    nytelefon(id,nummer) {
    if(!this.#studentarkiv.has(id)) return null;
    if(this.#studentarkiv.get(id).tlf === undefined){
     this.#studentarkiv.get(id).tlf = new Set();
    }

    const tlf = this.#studentarkiv.get(id).tlf;
    if(tlf.has(nummer)){
    return false
    } else {
    tlf.add(nummer);
    return true
    }

    }

}
